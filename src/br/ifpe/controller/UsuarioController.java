package br.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpe.basicas.Usuario;
import br.ifpe.dao.UsuarioDao;



@Controller
public class UsuarioController {

	@RequestMapping("/cdu")
	public String cadastrar() {
		return "usuario/cadastrarUsuario";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "index";
	}

	@RequestMapping("incluirProduto")
	public String incluirUsuario(Usuario usuario) {

		UsuarioDao dao = new UsuarioDao();
		dao.inserir(usuario);
		return "";
	}
	
	@RequestMapping("/paginaInicial")
	public String paginaHome() {
		return "usuario/home";
	}
}
