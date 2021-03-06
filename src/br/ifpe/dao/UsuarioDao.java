package br.ifpe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ifpe.basicas.Perfil;
import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.basicas.Usuario;
import br.ifpe.excecoes.UsuarioRepetidoException;
import br.ifpe.util.ConnectionFactory;

public class UsuarioDao {

	private Connection connection;

	public UsuarioDao() {
		try {
			this.connection = (Connection) new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// iserir
	public void inserir(Usuario usuario) throws UsuarioRepetidoException {
		try {
			String sql = "INSERT INTO usuario(nome, matricula, perfil) VALUES (?,?,?)";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getMatricula());
			stmt.setString(3, usuario.getPerfil().toString());

			stmt.execute();
			connection.close();

		} catch (SQLIntegrityConstraintViolationException e) {
			// esta exceção é esclusiva para violação de chave unica
			throw new UsuarioRepetidoException(e);

		}

		catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	// alterar usuario
	public void alterar(Usuario usuario) throws UsuarioRepetidoException {

		String sql = "UPDATE usuario SET nome=?, matricula=?, perfil=? WHERE id=?";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getMatricula());
			stmt.setString(3, usuario.getPerfil().toString());
			stmt.setInt(4, usuario.getId());

			stmt.execute();
			connection.close();

		} catch (SQLIntegrityConstraintViolationException e) {
			// esta exceção é esclusiva para violação de chave unica
			throw new UsuarioRepetidoException(e);

		}

		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// Atualizando a senha do usuário antes logar no sistema
	public void alterarSenha(Usuario usuario) {

		String sql = "UPDATE usuario SET senha=? WHERE id=?";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, usuario.getSenha());
			stmt.setInt(2, usuario.getId());

			stmt.execute();
			connection.close();

		}

		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// montar objeto
	private Usuario montarObjeto(ResultSet rs) throws SQLException {

		Usuario usuario = new Usuario();

		usuario.setId(rs.getInt("id"));
		usuario.setNome(rs.getString("nome"));
		usuario.setExcluido(rs.getBoolean("excluido"));
		usuario.setMatricula(rs.getString("matricula"));
		usuario.setSenha(rs.getString("senha"));
		usuario.setPerfil(Perfil.valueOf(rs.getString("perfil")));

		return usuario;
	}

	// listar usuario
	public List<Usuario> listar() {

		try {

			List<Usuario> listarUsuario = new ArrayList<Usuario>();
			String sql = "SELECT * FROM usuario ORDER BY nome";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				listarUsuario.add(montarObjeto(rs));
			}

			rs.close();
			stmt.close();
			connection.close();

			return listarUsuario;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//  este listar é usado na pagina de solicitacao listar
		public List<Usuario> listarUsuarioAtivo() {

			try {

				List<Usuario> listarUsuarioAtivo = new ArrayList<Usuario>();
				String sql = "SELECT * FROM usuario where excluido = true ORDER BY nome";
				PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					listarUsuarioAtivo.add(montarObjeto(rs));
				}

				rs.close();
				stmt.close();
				connection.close();

				return listarUsuarioAtivo;

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	// remover logico
	public void removerLogico(Usuario usuario) {

		String sql = "UPDATE usuario SET excluido = ? WHERE id = ?";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);

			stmt.setBoolean(1, usuario.isExcluido());
			stmt.setInt(2, usuario.getId());

			stmt.execute();
			// connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// buscar por id
	public Usuario buscarPorId(int id) {

		try {

			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario WHERE id = ?");
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			Usuario usuario = new Usuario();

			if (rs.next()) {
				usuario = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
			// connection.close();

			return usuario;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// pesquisar usuario
	public List<Usuario> pesquisar(Usuario usuario) {
		try {
			List<Usuario> listaUsuario = new ArrayList<Usuario>();
			PreparedStatement stmt = null;

			if (!usuario.getNome().equals("") && usuario.getMatricula().equals("")) {
				stmt = this.connection.prepareStatement("SELECT * FROM usuario WHERE nome LIKE ? ORDER BY nome");
				stmt.setString(1, "%" + usuario.getNome() + "%");
			}

			else if (usuario.getNome().equals("") && !usuario.getMatricula().equals("")) {
				stmt = this.connection.prepareStatement("SELECT * FROM usuario WHERE matricula LIKE ? ORDER BY nome");
				stmt.setString(1, "%" + usuario.getMatricula() + "%");
			}

			else if (!usuario.getNome().equals("") && !usuario.getMatricula().equals("")) {
				stmt = this.connection
						.prepareStatement("SELECT * FROM usuario WHERE nome LIKE ? AND matricula LIKE ? ORDER BY nome");
				stmt.setString(1, "%" + usuario.getNome() + "%");
				stmt.setString(2, "%" + usuario.getMatricula() + "%");
			}

			else {
				stmt = this.connection.prepareStatement("SELECT * FROM usuario ORDER BY nome");
			}

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				listaUsuario.add(montarObjeto(rs));
			}
			rs.close();
			stmt.close();
			connection.close();

			return listaUsuario;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

//	login
	public Usuario buscarUsuario(Usuario usuario) {
		try {

			Usuario usuarioConsultado = null;

			PreparedStatement stmt = this.connection
					.prepareStatement("select * from usuario where matricula = ? and senha = ?");

			stmt.setString(1, usuario.getMatricula());
			stmt.setString(2, usuario.getSenha());

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				usuarioConsultado = montarObjeto(rs);
			}
			rs.close();
			stmt.close();
			return usuarioConsultado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}// fim
