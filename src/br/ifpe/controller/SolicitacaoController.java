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

	// PESQUISAR OCORRENCIA INCOMPLETO
	@RequestMapping("/pesquisarOcorrencia")
	public String exibirPesquisarOcorrencia(Model model) {

		OcorrenciaDao dao = new OcorrenciaDao();
		List<Ocorrencia> listarOcorrencia = dao.listarOcorrencia();
		model.addAttribute("listarOcorrencia", listarOcorrencia);

		return "ocorrencia/pesquisarOcorrencia";
	}

	// REGISTRAR SOLICITACAO / REGISTRAR OCORRENCIA
		@RequestMapping("/registrarSolicitacao")
		public String registrarSolicitacao(@Valid Solicitacao solicitacao, BindingResult bindingResult,
				@RequestParam("file") MultipartFile imagem, Model model, HttpServletRequest request, HttpSession session) {

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
			ocorrencia.setAcao(Ocorrencia.OCORRENCIA_SOLICITACAO_REGISTRADA); // utilizando a constante
			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			ocorrencia.setUsuario(usuario);// setando o usuario que vem no objeto solicitacao

			OcorrenciaDao dao3 = new OcorrenciaDao();
			dao3.registrar(ocorrencia);

			return "forward:rs";
		}

	// listar solicitacao obs: esta função não esta sendo utilizado
	@RequestMapping("/as")
	public String acompanharSolicitacao(Solicitacao solicitacao, HttpSession session, Model model) {

		// CARREGANDO O CONTEUDO DO SELECT PARA CHAVE ESTRANGEIRA
		TipoSolicitacaoDao dao1 = new TipoSolicitacaoDao();
		List<TipoSolicitacao> listaTipoSolicitacaoAtiva = dao1.listarTipoSolicitacaoAtiva();
		model.addAttribute("listaTipoSolicitacaoAtiva", listaTipoSolicitacaoAtiva);

		// CARREGANDO O CONTEUDO DO SELECT PARA CHAVE ESTRANGEIRA
		UsuarioDao dao2 = new UsuarioDao();
		List<Usuario> listarUsuarioAtivo = dao2.listarUsuarioAtivo();
		model.addAttribute("listarUsuarioAtivo", listarUsuarioAtivo);

		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

		SolicitacaoDao dao = new SolicitacaoDao();
		List<Solicitacao> listarSolicitacao = dao.listarPorId(usuario);

		model.addAttribute("listarSolicitacao", listarSolicitacao);

		return "solicitacao/acompanharSolicitacao";
	}

	// pesquisar solicitacao
	@RequestMapping("/pesquisarSolicitacao")
	public String pesquisarSolicitacao(Solicitacao solicitacao, HttpSession session, Model model) {

		// CARREGANDO O CONTEUDO DO SELECT PARA CHAVE ESTRANGEIRA
		TipoSolicitacaoDao dao1 = new TipoSolicitacaoDao();
		List<TipoSolicitacao> listaTipoSolicitacaoAtiva = dao1.listarTipoSolicitacaoAtiva();
		model.addAttribute("listaTipoSolicitacaoAtiva", listaTipoSolicitacaoAtiva);

		// CARREGANDO O CONTEUDO DO SELECT PARA CHAVE ESTRANGEIRA
		UsuarioDao dao2 = new UsuarioDao();
		List<Usuario> listarUsuarioAtivo = dao2.listarUsuarioAtivo();
		model.addAttribute("listarUsuarioAtivo", listarUsuarioAtivo);

		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

		SolicitacaoDao dao = new SolicitacaoDao();
		List<Solicitacao> listarSolicitacao = dao.listarPorId(usuario);

		if (listarSolicitacao.isEmpty())
			model.addAttribute("mensagemNaoEncontrada",
					"Não encontrada.<br> Click no botão Pesquisar, para listar Todas!");
		else
			model.addAttribute("listarSolicitacao", listarSolicitacao);

		return "solicitacao/acompanharSolicitacao";
	}

	// REMOVER LOGICO / registrar ocorrencia
		@RequestMapping("removerSolicitacao")
		public String removerSolicitacao(Solicitacao solicitacao, Model model, HttpSession session) {

		// registrar ocorrencia
			Ocorrencia ocorrencia = new Ocorrencia();
			ocorrencia.setSolicitacao(solicitacao);
			ocorrencia.setAcao(Ocorrencia.OCORRENCIA_SOLICITACAO_EXCLUIDA); // utilizando a constante
			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			ocorrencia.setUsuario(usuario);// setando o usuario que vem no objeto solicitacao

			OcorrenciaDao dao3 = new OcorrenciaDao();
			dao3.registrar(ocorrencia);
	//	
			//removendo logicamente
			SolicitacaoDao dao = new SolicitacaoDao();
			dao.removerLogico(solicitacao.getId());
			model.addAttribute("mensagemExclusao", "Solicitação excluída com Sucesso!");
					
			return "forward:as";
		}

//	exibir a pagina encaminhar
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

//	REGISTRAR ENCAMINHAR
	@RequestMapping("registrarEncaminhamento")
	public String registrarEncaminhamento(Solicitacao solicitacao, @RequestParam("parecer") String parecer,
			BindingResult bindingResult, Model model, HttpSession session) {

		if (bindingResult.hasErrors())
			return "forward:encaminharPara";

		SolicitacaoDao dao = new SolicitacaoDao();
		dao.updateEncaminhar(solicitacao);
		model.addAttribute("mensagemSucessoEncaminhar", "Solicitação encaminhada com sucesso!");

//		OCORRENCIA
		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setParecer(parecer);
		ocorrencia.setSolicitacao(solicitacao);
		ocorrencia.setAcao(Ocorrencia.OCORRENCIA_SOLICITACAO_ENCAMINHADA); // utilizando a constante
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		ocorrencia.setUsuario(usuario);// setando o usuario que vem no objeto solicitacao

		OcorrenciaDao dao3 = new OcorrenciaDao();
		dao3.registrar(ocorrencia);

		return "forward:encaminharPara";
	}
	
	// exibir pagina de alterar
	@RequestMapping("exibirAlterarSolicitacao")
	public String exibirAlterarSolicitacao(Solicitacao solicitacao, Model model) {

		SolicitacaoDao dao = new SolicitacaoDao();
		Solicitacao solicitacao2 = dao.buscarPorId(solicitacao.getId());
		model.addAttribute("solicitacao", solicitacao2);

		// CARREGANDO O CONTEUDO DO SELECT PARA CHAVE ESTRANGEIRA
		TipoSolicitacaoDao dao1 = new TipoSolicitacaoDao();
		List<TipoSolicitacao> listaTipoSolicitacaoAtiva = dao1.listarTipoSolicitacaoAtiva();
		model.addAttribute("listaTipoSolicitacaoAtiva", listaTipoSolicitacaoAtiva);

		// CARREGANDO O CONTEUDO DO SELECT PARA CHAVE ESTRANGEIRA
		UsuarioDao dao2 = new UsuarioDao();
		List<Usuario> listarUsuarioAtivo = dao2.listarUsuarioAtivo();
		model.addAttribute("listarUsuarioAtivo", listarUsuarioAtivo);

		return "solicitacao/alterarSolicitacao";
	}

	// ALTERAR
	@RequestMapping("/alterarSolicitacao")
	public String alterarTipo(Solicitacao solicitacao, Model model) {

		SolicitacaoDao dao = new SolicitacaoDao();
		dao.alterarSolicitacao(solicitacao);
		model.addAttribute("mensagem", "Solicitação Alterada com Sucesso!");

		return "forward:as";

	}

	@RequestMapping("updateStatus")
	public String updateStatus(Solicitacao solicitacao, BindingResult bindingResult, Model model, HttpSession session) {

		if (bindingResult.hasErrors())
			return "forward:pesquisarSolicitacao";

		SolicitacaoDao dao = new SolicitacaoDao();
		dao.atualizarStatus(solicitacao);
		model.addAttribute("mensagemSucessoEncaminhar", "Solicitação encaminhada com sucesso!");

//		OCORRENCIA
		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setSolicitacao(solicitacao);
		ocorrencia.setAcao(solicitacao.getStatus().toString());
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		ocorrencia.setUsuario(usuario);// setando o usuario que vem no objeto solicitacao

		OcorrenciaDao dao3 = new OcorrenciaDao();
		dao3.registrar(ocorrencia);
		
		return "forward:pesquisarSolicitacao";
	}

}// fim
