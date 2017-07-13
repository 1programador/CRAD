package br.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpe.basicas.Usuario;
import br.ifpe.dao.UsuarioDao;

@Controller
public class UsuarioController {

	@RequestMapping("/cdu")
	public String paginaUsuario() {
		return "usuario/cadastrarUsuario";
	}

	@RequestMapping("/login")
	public String login() {
		return "index";
	}

	@RequestMapping("incluirUsuario")
	public String incluirUsuario(Usuario usuario, Model model) {

		UsuarioDao dao = new UsuarioDao();
		dao.inserir(usuario);
		model.addAttribute("mensagem", "O usuário " + usuario.getNome() + " foi cadastrado com Sucesso !");

		return "forward:cdu";
	}
	
	@RequestMapping("removerUsuario")
	public String removerProduto(Usuario usuario, Model model) {
		
	UsuarioDao dao = new UsuarioDao();
	dao.remover(usuario);
	
	model.addAttribute("mensagem", "Usuário Removido com Sucesso");
	return "usuario/listarUsuario";
	}

	@RequestMapping("/paginaInicial")
	public String paginaHome() {
		return "usuario/home";
	}
	
	@RequestMapping("/lu")
	public String listarUsuario() {
		return "usuario/listarUsuario";
	}
}
