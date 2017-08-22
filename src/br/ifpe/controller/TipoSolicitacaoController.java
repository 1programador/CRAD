package br.ifpe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.dao.TipoSolicitacaoDao;
import br.ifpe.excecoes.*;


@Controller
public class TipoSolicitacaoController {

//	EXIBIR INCLUIR
	@RequestMapping("/cds")
	public String exibirTipoSolicitacao() {
		return "tipoSolicitacao/cadastrarTipoSolicitacao";
	}

//	INCLUIR
	@RequestMapping("incluirTipoSolicitacao")
	public String incluirServico(@Valid TipoSolicitacao tipoSolicitacao, BindingResult result,Model model) {

		if(result.hasErrors()) return "forward:cds";
		
		try {
			TipoSolicitacaoDao dao = new TipoSolicitacaoDao();
			dao.inserir(tipoSolicitacao);
			model.addAttribute("mensagemSucesso", "Tipo de solicitação cadastrado com Sucesso!");

		} catch (

		TipoSolicitacaoRepetidaException e) {
			e.printStackTrace();

			model.addAttribute("mensagemJaExiste", "Esta descrição já existe em outro tipo de solicitação!");
			// este é um retorno se cair na exceçao da chave unique
			return "forward:cds";

		}
		return "forward:cds";
	}

//	REMOVER LOGICO	
	@RequestMapping("removerTipoSolicitacao")
	public String removerTipoSolicitacao(TipoSolicitacao tipoSolicitacao, Model model) {

		TipoSolicitacaoDao dao = new TipoSolicitacaoDao();
		
		if(tipoSolicitacao.isExcluido()){
			tipoSolicitacao.setExcluido(false);
			dao.removerLogico(tipoSolicitacao);
			model.addAttribute("mensagemExclusao", "Tipo de Solicitação ativado com Sucesso!");
		}
		else {
			tipoSolicitacao.setExcluido(true);
			dao.removerLogico(tipoSolicitacao);
			model.addAttribute("mensagemExclusao", "Tipo de Solicitação desativado com Sucesso!");
		}
		
		return "forward:listarSolicitacao";
	}

//	EXIBIR PESQUISAR TIPO SOLICITACAO
	@RequestMapping("/listarSolicitacao")
	public String listarSolicitacao(TipoSolicitacao tipoSolicitacao, Model model) {
		
			TipoSolicitacaoDao dao = new TipoSolicitacaoDao();
			List<TipoSolicitacao> listarTipoSolicitacao = dao.listarTipoSolicitacao();
			model.addAttribute("listarTipoSolicitacao", listarTipoSolicitacao);
			
		
		return "tipoSolicitacao/listarTipoSolicitacao";
	}

//	exibir pagina de alterar
	@RequestMapping("exibirAlterarTipo")
	public String exibirAlterarTipo(TipoSolicitacao tipoSolicitacao, Model model) {

		TipoSolicitacaoDao dao = new TipoSolicitacaoDao();
		TipoSolicitacao solicitacao = dao.buscarPorId(tipoSolicitacao.getId());
		
		model.addAttribute("tipoSolicitacao", solicitacao);
		return "tipoSolicitacao/alterarTipoSolicitacao";
	}
	
//	ALTERAR	
	@RequestMapping("/alterarTipo")
	   public String alterarTipo(@Valid TipoSolicitacao tipoSolicitacao,BindingResult result, Model model) throws TipoSolicitacaoRepetidaException {

		if(result.hasErrors())
			return "forward:exibirAlterarTipo";
		
		try {
			TipoSolicitacaoDao dao = new TipoSolicitacaoDao();
			dao.alterarTipo(tipoSolicitacao);
			model.addAttribute("mensagem", "Tipo de Solicitação Alterada com Sucesso!");
			
		} catch (TipoSolicitacaoRepetidaException e) {
			e.printStackTrace();
			model.addAttribute("mensagemAlterarJaExiste", "Esta descrição já existe em outro tipo de solicitação!");
			// este é um retorno se cair na exceçao da chave unique
			return "forward:exibirAlterarTipo";
		
		}
		return "forward:listarSolicitacao";
			}
			
	   
	   }
