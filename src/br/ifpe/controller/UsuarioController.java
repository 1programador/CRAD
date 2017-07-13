package br.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpe.basicas.Usuario;
import br.ifpe.dao.UsuarioDao;
import br.ifpe.dao.UsuarioRepetidoException;

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

		try {
			UsuarioDao dao = new UsuarioDao();
			dao.inserir(usuario);
			model.addAttribute("mensagemSucesso", "O usuário " + usuario.getNome() + " foi cadastrado com Sucesso !");

			//tratando
		} catch (UsuarioRepetidoException e) {
			e.printStackTrace();
			
			model.addAttribute("mensagemJaExiste", "A matricula " + usuario.getMatricula() + " ja existe !");
			//este é um retorno se cair na exceçao da chave unique
		return "forward:cdu";
		}
		return "forward:cdu";
	}
	
	@RequestMapping("removerUsuario")
	public String removerProduto(Usuario usuario, Model model) {
		
	UsuarioDao dao = new UsuarioDao();
	dao.remover(usuario);
	
	model.addAttribute("mensagem", "Usuário Removido com Sucesso");
	return "forward:lu";
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
