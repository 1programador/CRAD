package br.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpe.basicas.Usuario;
import br.ifpe.dao.UsuarioDao;



@Controller
public class ProdutoController {

	@RequestMapping("/cdu")
	public String ola() {
		return "cadastrarUsuario";
	}

	@RequestMapping("incluirProduto")
	public String incluirUsuario(Usuario usuario) {

		UsuarioDao dao = new UsuarioDao();
		dao.inserir(usuario);
		return "";
	}
}
