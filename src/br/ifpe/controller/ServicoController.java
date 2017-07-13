package br.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.dao.ServicoDao;

@Controller
public class ServicoController {

	//exibir pagina
	@RequestMapping("/cds")
	public String paginaServico() {
		return "servico/cadastrarServico";
	}
	
	@RequestMapping("incluirServico")
	public String incluirServico(TipoSolicitacao servico, Model model) {

		ServicoDao dao = new ServicoDao();
		dao.inserir(servico);
		model.addAttribute("mensagemServico", "O serviço foi incerido com Sucesso !");

		return "forward:cds";
	}
}
