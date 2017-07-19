package br.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.dao.TipoSolicitacaoDao;
import br.ifpe.dao.TipoSolicitacaoRepitidaException;

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
		
		model.addAttribute("mensagemSucesso", "Tipo de solicitação cadastrado com Sucesso!");
		
			
		} catch (TipoSolicitacaoRepitidaException e) {
			e.printStackTrace();
			
			model.addAttribute("mensagemJaExiste", "Esta descrição já existe em outro tipo de solicitação!");
			//este é um retorno se cair na exceçao da chave unique
		return "forward:cds";
		
		}
		return "forward:cds";
	}
	
	
}
