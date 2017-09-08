package br.ifpe.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ifpe.basicas.Ocorrencia;
import br.ifpe.basicas.Solicitacao;
import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.basicas.Usuario;
import br.ifpe.dao.OcorrenciaDao;
import br.ifpe.dao.SolicitacaoDao;
import br.ifpe.dao.TipoSolicitacaoDao;
import br.ifpe.dao.UsuarioDao;
import br.ifpe.util.Util;

@Controller
public class SolicitacaoController {

	// exibir registrar solicitacao
	@RequestMapping("/rs")
	public String exibirRegistrarSolicitacao(Model model) {

		// CARREGANDO O CONTEUDO DO SELECT PARA CHAVE ESTRANGEIRA
		TipoSolicitacaoDao dao1 = new TipoSolicitacaoDao();
		List<TipoSolicitacao> listaTipoSolicitacaoAtiva = dao1.listarTipoSolicitacaoAtiva();
		model.addAttribute("listaTipoSolicitacaoAtiva", listaTipoSolicitacaoAtiva);

		// CARREGANDO O CONTEUDO DO SELECT PARA CHAVE ESTRANGEIRA
		UsuarioDao dao2 = new UsuarioDao();
		List<Usuario> listarUsuarioAtivo = dao2.listarUsuarioAtivo();
		model.addAttribute("listarUsuarioAtivo", listarUsuarioAtivo);

		return "solicitacao/cadastrarSolicitacao";
	}

	// exibir registrar solicitacao
	@RequestMapping("/pesquisarOcorrencia")
	public String exibirPesquisarOcorrencia(Model model) {

		OcorrenciaDao dao = new OcorrenciaDao();
		List<Ocorrencia> listarOcorrencia = dao.listarOcorrencia();
		model.addAttribute("listarOcorrencia", listarOcorrencia);

		return "ocorrencia/pesquisarOcorrencia";
	}

	// REGISTRAR SOLICITACAO REGISTRAR OCORRENCIA
	@RequestMapping("/registrarSolicitacao")
	public String registrarSolicitacao(@Valid Solicitacao solicitacao, BindingResult bindingResult,
			@RequestParam("file") MultipartFile imagem, Model model, HttpServletRequest request) {

		if (bindingResult.hasErrors())
			return "forward:rs";

		if (Util.fazerUploadImagem(imagem)) {
			solicitacao.setAnexos(Calendar.getInstance().getTime() + " - " + imagem.getOriginalFilename());
		}

		SolicitacaoDao dao = new SolicitacaoDao();
		dao.registrar(solicitacao);
		model.addAttribute("mensagemSucessoSolicitacao", "Solicitação registrada com sucesso!");

		// registrar ocorrencia
		SolicitacaoDao dao2 = new SolicitacaoDao();

		Solicitacao solicitacaoCadastrada = dao2.obterUltimaSolicitacao();

		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setSolicitacao(solicitacaoCadastrada);
		ocorrencia.setAcao(Ocorrencia.OCORRENCIA_REGISTRO_SOLICITACAO); // utilizando a constante
		ocorrencia.setUsuario(solicitacao.getUsuario());// setando o usuario que vem no objeto solicitacao

		OcorrenciaDao dao3 = new OcorrenciaDao();
		dao3.registrar(ocorrencia);

		return "forward:rs";
	}

	// listar solicitacao
	@RequestMapping("/as")
	public String acompanharSolicitacao(Solicitacao solicitacao, HttpSession session, Model model) {

		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

		SolicitacaoDao dao = new SolicitacaoDao();
		List<Solicitacao> listarSolicitacao = dao.listarPorId(usuario);

		model.addAttribute("listarSolicitacao", listarSolicitacao);

		return "solicitacao/acompanharSolicitacao";
	}

	// REMOVER LOGICO
	@RequestMapping("removerSolicitacao")
	public String removerSolicitacao(Solicitacao Solicitacao, Model model) {

		SolicitacaoDao dao = new SolicitacaoDao();
		dao.removerLogico(Solicitacao.getId());

		model.addAttribute("mensagemExclusao", "Solicitação excluída com Sucesso!");
		return "forward:as";
	}

	@RequestMapping("encaminharPara")
	public String encaminharPara(Usuario usuario, Solicitacao solicitacao, Model model) {

		UsuarioDao dao2 = new UsuarioDao();
		List<Usuario> listarUsuarioAtivo = dao2.listarUsuarioAtivo();
		model.addAttribute("listarUsuarioAtivo", listarUsuarioAtivo);

		SolicitacaoDao dao = new SolicitacaoDao();
		List<Solicitacao> listarSolicitacao = dao.listar();
		model.addAttribute("listarSolicitacao", listarSolicitacao);

		return "solicitacao/encaminhar";
	}

	@RequestMapping("registrarEncaminhamento")
	public String registrarEncaminhamento(Solicitacao solicitacao, @RequestParam("parecer") String parecer,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors())
			return "forward:encaminharPara";

		SolicitacaoDao dao = new SolicitacaoDao();
		dao.updateEncaminhar(solicitacao);
		model.addAttribute("mensagemSucessoEncaminhar", "Solicitação encaminhada com sucesso!");

		SolicitacaoDao dao2 = new SolicitacaoDao();
		Solicitacao solicitacaoCadastrada = dao2.obterUltimaSolicitacao();

		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setParecer(parecer);
		ocorrencia.setSolicitacao(solicitacao);
		ocorrencia.setAcao(Ocorrencia.OCORRENCIA_SOLICITACAO_ENCAMINHADA); // utilizando a constante
		ocorrencia.setUsuario(solicitacao.getUsuario());// setando o usuario que vem no objeto solicitacao

		OcorrenciaDao dao3 = new OcorrenciaDao();
		dao3.registrar(ocorrencia);

		return "forward:encaminharPara";
	}

}// fim
