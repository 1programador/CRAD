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

	@RequestMapping("/paginaInicial")
	public String paginaHome() {
		return "usuario/home";
	}
}
