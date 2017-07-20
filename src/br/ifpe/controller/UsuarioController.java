package br.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpe.basicas.Usuario;
import br.ifpe.dao.UsuarioDao;
import br.ifpe.dao.UsuarioRepetidoException;

@Controller
public class UsuarioController {

	@RequestMapping("/home")
	public String paginaHome() {
		return "principal/home";
	}

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

			// tratando
		} catch (UsuarioRepetidoException e) {
			e.printStackTrace();

			model.addAttribute("mensagemJaExiste", "A matricula " + usuario.getMatricula() + " ja existe !");
			// este é um retorno se cair na exceçao da chave unique
			return "forward:cdu";
		}
		return "forward:cdu";
	}

	@RequestMapping("removerUsuario")
	public String removerUsuario(Usuario usuario, Model model) {

		UsuarioDao dao = new UsuarioDao();
		dao.remover(usuario);

		model.addAttribute("mensagemExclusao", "Usuário removido com sucesso");
		return "forward:lu";
	}

	@RequestMapping("/lu")
	public String listarUsuario() {
		return "usuario/listarUsuario";
	}

	@RequestMapping("/exibirAlterarUsuario")
	public String exibirAlterarUsuario(Usuario usuario, Model model) {

		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioCompleto = dao.buscarPorId(usuario.getId());

		model.addAttribute("usuario", usuarioCompleto);
		return "usuario/alterarUsuario";
	}

	@RequestMapping("/alterar")
	public String alterarUsuario(Usuario usuario, Model model) {

		UsuarioDao dao = new UsuarioDao();
		dao.alterar(usuario);
		model.addAttribute("mensagemAlterarSucesso", "Usuário Alterado com Sucesso!");

		return "forward:listarUsuario";
	}

}
