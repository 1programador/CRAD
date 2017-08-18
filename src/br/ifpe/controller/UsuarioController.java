package br.ifpe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
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

	// exibir pagina cadastrar
	@RequestMapping("/cdu")
	public String paginaUsuario() {
		return "usuario/cadastrarUsuario";
	}

	@RequestMapping("incluirUsuario")
	public String incluirUsuario(@Valid Usuario usuario, BindingResult result, Model model) {

		if (result.hasErrors())
			return "forward:cdu";

		try {
			UsuarioDao dao = new UsuarioDao();
			dao.inserir(usuario);
			model.addAttribute("mensagemSucesso", "O usuário " + usuario.getNome() + " foi cadastrado com Sucesso !");

			// tratando a exceção
		} catch (UsuarioRepetidoException e) {
			e.printStackTrace();

			model.addAttribute("mensagemJaExiste",
					"A matricula " + usuario.getMatricula() + " ja esta cadastrada em outro usuario !");
			// este é um retorno se cair na exceção da chave unique
			return "forward:cdu";
		}
		return "forward:cdu";
	}

	// excluir logico
	@RequestMapping("removerUsuario")
	public String removerUsuario(Usuario usuario, Model model) {

		UsuarioDao dao = new UsuarioDao();
		dao.removerLogico(usuario);

		model.addAttribute("mensagemExclusao", "Usuário removido com sucesso");
		return "forward:lu";
	}

	// exibir pesquisar usuario
	@RequestMapping("/lu")
	public String listarUsuario(Usuario usuario, Model model) {

		UsuarioDao dao = new UsuarioDao();
		List<Usuario> listaUsuario = dao.listar();
		model.addAttribute("listaUsuario", listaUsuario);

		return "usuario/listarUsuario";
	}

	// pesquisar usuario
	@RequestMapping("/pesquisarUsuario")
	public String pesquisarUsuario(Usuario usuario, Model model) {

		UsuarioDao dao = new UsuarioDao();
		List<Usuario> listaUsuario = dao.pesquisar(usuario);
		model.addAttribute("listaUsuario", listaUsuario);

		return "usuario/listarUsuario";
	}

	// exibir pagina alterar
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
	public String alterarUsuario(@Valid Usuario usuario, BindingResult result, Model model) {

		// este if pergunta se o campo esta vazio
		if (result.hasErrors()) {
			
			List<Perfil> perfil = new ArrayList<Perfil>();
			for (Perfil p : Perfil.values()) {
				perfil.add(p);
			}
			model.addAttribute("listaPerfil", perfil);
			model.addAttribute("usuario", usuario);
			return "usuario/alterarUsuario";
		}

		try {
			UsuarioDao dao = new UsuarioDao();
			dao.alterar(usuario);
			model.addAttribute("mensagemAlterarSucesso", "Usuário Alterado com Sucesso!");

			// tratando a exceção da chave unica
		} catch (UsuarioRepetidoException e) {
			e.printStackTrace();

			model.addAttribute("mensagemJaExiste",
					"A matricula " + usuario.getMatricula() + " ja esta cadastrada em outro usuario !");
			// este é um retorno se cair na exceção da chave unique
			return "forward:exibirAlterarUsuario";
		}

		return "forward:lu";
	}

//  LOGIN
	@RequestMapping("efetuarLogin")
	public String efetuarLogin(Usuario usuario, HttpSession session, Model model) {

		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioLogado = dao.buscarUsuario(usuario);

		if (usuarioLogado != null) {
			session.setAttribute("usuarioLogado", usuarioLogado);
			if( usuario.getSenha().equals("123")){
				return "usuario/alterarSenha";
			}
			
			return "principal/home";
		}
		model.addAttribute("msg", "Não foi encontrado nenhum usuário com a matrícula informada.");
		return "index";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	
	@RequestMapping("/alterarSenha")
	public String alterarSenha(Usuario usuario, Model model) {
		
			UsuarioDao dao = new UsuarioDao();
			dao.alterarSenha(usuario);
			
			return "principal/home";
		}

}// fim
