package br.ifpe.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.dao.TipoSolicitacaoDao;
import br.ifpe.excecoes.TipoSolicitacaoRepitidaException;

@Controller
public class TipoSolicitacaoController {

	@RequestMapping("/cds")
	public String paginaServico() {
		return "tipoSolicitacao/cadastrarTipoSolicitacao";
	}

	@RequestMapping("incluirTipoSolicitacao")
	public String incluirServico(@Valid TipoSolicitacao tipoSolicitacao, BindingResult result,Model model) {

		if(result.hasErrors()) return "forward:cds";
		
		try {
			TipoSolicitacaoDao dao = new TipoSolicitacaoDao();
			dao.inserir(tipoSolicitacao);
			model.addAttribute("mensagemSucesso", "Tipo de solicitação cadastrado com Sucesso!");

		} catch (

		TipoSolicitacaoRepitidaException e) {
			e.printStackTrace();

			model.addAttribute("mensagemJaExiste", "Esta descrição já existe em outro tipo de solicitação!");
			// este é um retorno se cair na exceçao da chave unique
			return "forward:cds";

		}
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
}
