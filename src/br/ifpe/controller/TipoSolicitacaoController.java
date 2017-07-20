package br.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.basicas.Usuario;
import br.ifpe.dao.TipoSolicitacaoDao;
<<<<<<< HEAD
import br.ifpe.dao.UsuarioDao;
=======
import br.ifpe.dao.TipoSolicitacaoRepitidaException;
>>>>>>> 7ebac350fca2536b0a8fecd12aee9048595d1d87

@Controller
public class TipoSolicitacaoController {


	@RequestMapping("/cds")
	public String paginaServico() {
		return "tipoSolicitacao/cadastrarTipoSolicitacao";
	}
	
	@RequestMapping("incluirTipoSolicitacao")
	public String incluirServico(TipoSolicitacao tipoSolicitacao, Model model) {

		try{
		TipoSolicitacaoDao dao = new TipoSolicitacaoDao();
		dao.inserir(tipoSolicitacao);
		
<<<<<<< HEAD
		model.addAttribute("mensagemServico", "Solicitação cadastrada com Sucesso!");

		return "forward:cds";
	}
	
	@RequestMapping("removerSolicitacao")
	public String removerUsuario(TipoSolicitacao tipoSolicitacao, Model model) {
		
	TipoSolicitacaoDao dao = new TipoSolicitacaoDao();
	dao.remover(tipoSolicitacao.getId());
	
	model.addAttribute("mensagemExclusao", "Solicitação excluida com Sucesso!");
	return "forward:listarSolicitacao";
	}
	
	
	@RequestMapping("/listarSolicitacao")
	public String listarSolicitacao() {
		return "tipoSolicitacao/listarTipoSolicitacao";
	}
	
	
=======
		model.addAttribute("mensagemSucesso", "Tipo de solicitação cadastrado com Sucesso!");
		
			
		} catch (TipoSolicitacaoRepitidaException e) {
			e.printStackTrace();
			
			model.addAttribute("mensagemJaExiste", "Esta descrição já existe em outro tipo de solicitação!");
			//este é um retorno se cair na exceçao da chave unique
		return "forward:cds";
		
		}
		return "forward:cds";
	}
	
>>>>>>> 7ebac350fca2536b0a8fecd12aee9048595d1d87
	
}
