package br.ifpe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpe.basicas.Perfil;
import br.ifpe.basicas.Usuario;
import br.ifpe.dao.UsuarioDao;
import br.ifpe.excecoes.UsuarioRepetidoException;

@Controller
public class UsuarioController {

	// ainda não funciona
		@RequestMapping("/login")
		public String login() {
			return "index";
		}
		
	@RequestMapping("/home")
	public String paginaHome() {
		return "principal/home";
	}

	@RequestMapping("/cdu")
	public String paginaUsuario() {
		return "usuario/cadastrarUsuario";
	}

	@RequestMapping("incluirUsuario")
	public String incluirUsuario(@Valid Usuario usuario, BindingResult result, Model model) {

		if (result.hasErrors()) { return "forward:cdu"; }
		
		try {
			UsuarioDao dao = new UsuarioDao();
			dao.inserir(usuario);
			model.addAttribute("mensagemSucesso", "O usuário " + usuario.getNome() + " foi cadastrado com Sucesso !");

			// tratando a exceção
		} catch (UsuarioRepetidoException e) {
			e.printStackTrace();

			model.addAttribute("mensagemJaExiste", "A matricula " + usuario.getMatricula() + " ja existe !");
			// este é um retorno se cair na exceção da chave unique
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
	
//	exibir pesquisar usuario
	@RequestMapping("/lu")
	public String listarUsuario(Usuario usuario, Model model) {
		
		UsuarioDao dao = new UsuarioDao();
		List<Usuario> listaUsuario = dao.listar();
		model.addAttribute("listaUsuario", listaUsuario);
		
		return "usuario/listarUsuario";
	}
	
	// pesquisar produto
		@RequestMapping("/pesquisarUsuario")
		public String pesquisarUsuario(Usuario usuario, Model model) {
			
			UsuarioDao dao = new UsuarioDao();
			List<Usuario> listaUsuario = dao.pesquisar(usuario);
			model.addAttribute("listaUsuario", listaUsuario);
		
			return "usuario/listarUsuario";
		}

	@RequestMapping("/exibirAlterarUsuario")
	public String exibirAlterarUsuario(Usuario usuario, Model model) {

		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioCompleto = dao.buscarPorId(usuario.getId());
		List<Perfil> perfil = new ArrayList<Perfil>();
		for (Perfil p : Perfil.values()) {
			perfil.add(p);
		}
		model.addAttribute("listaPerfil", perfil);
		model.addAttribute("usuario", usuarioCompleto);
		return "usuario/alterarUsuario";
	}

	@RequestMapping("/alterar")
	public String alterarUsuario(Usuario usuario, Model model) {

		UsuarioDao dao = new UsuarioDao();
		dao.alterar(usuario);
		model.addAttribute("mensagemAlterarSucesso", "Usuário Alterado com Sucesso!");

		return "forward:lu";
	}

}//fim
