package br.ifpe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpe.basicas.Solicitacao;
import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.basicas.Usuario;
import br.ifpe.dao.SolicitacaoDao;
import br.ifpe.dao.TipoSolicitacaoDao;
import br.ifpe.dao.UsuarioDao;

@Controller
public class SolicitacaoController {

//	exibir registrar solicitacao
	@RequestMapping("/rs")
		public String exibirRegistrarSolicitacao(Model model){
		
		//CARREGANDO O CONTEUDO DO SELECT PARA CHAVE ESTRANGEIRA
		TipoSolicitacaoDao dao1 = new TipoSolicitacaoDao();
		List<TipoSolicitacao> listaTipoSolicitacao = dao1.listar();
		model.addAttribute("listaTipoSolicitacao", listaTipoSolicitacao);
		
		//CARREGANDO O CONTEUDO DO SELECT PARA CHAVE ESTRANGEIRA
		UsuarioDao dao2 = new UsuarioDao();
		List<Usuario> listaUsuario = dao2.listar();
		model.addAttribute("listaUsuario", listaUsuario);
		
		return "solicitacao/cadastrarSolicitacao";
	}

//	REGISTRAR SOLICITACAO
	@RequestMapping("/registrarSolicitacao")
		public String registrarSolicitacao(@Valid Solicitacao solicitacao,BindingResult bindingResult, Model model){
		
			if(bindingResult.hasErrors()) 
				return "forward:rs";
		
			SolicitacaoDao dao = new SolicitacaoDao();
			dao.registrar(solicitacao);
			model.addAttribute("mensagemSucessoSolicitacao","Registrada com sucesso!");
			
		return "forward:rs";
	}
	
//	listar solicitacao
	@RequestMapping("/as")
	public String acompanharSolicitacao(Solicitacao solicitacao, Model model) {
		
		SolicitacaoDao dao = new SolicitacaoDao();
		List<Solicitacao> listarSolicitacao = dao.listar();
		model.addAttribute("listarSolicitacao", listarSolicitacao);
		
		return "solicitacao/acompanharSolicitacao";
	}
	
//	REMOVER LOGICO	
	@RequestMapping("removerSolicitacao")
	public String removerSolicitacao(Solicitacao Solicitacao, Model model) {

		SolicitacaoDao dao = new SolicitacaoDao();
		dao.removerLogico(Solicitacao.getId());

		model.addAttribute("mensagemExclusao", "Solicitação excluida com Sucesso!");
		return "forward:as";
	}
	
}//fim
