package br.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.dao.TipoSolicitacaoDao;

@Controller
public class TipoSolicitacaoController {

	//exibir pagina
	@RequestMapping("/cds")
	public String paginaServico() {
		return "servico/cadastrarServico";
	}
	
	@RequestMapping("incluirServico")
	public String incluirServico(TipoSolicitacao tipoSolicitacao, Model model) {

		TipoSolicitacaoDao dao = new TipoSolicitacaoDao();
		dao.inserir(tipoSolicitacao);
		
		model.addAttribute("mensagemServico", "O serviço foi incerido com Sucesso !");

		return "forward:cds";
	}
}
