package br.ifpe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ifpe.basicas.Perfil;
import br.ifpe.basicas.Solicitacao;
import br.ifpe.basicas.Status;
import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.basicas.Usuario;
import br.ifpe.excecoes.UsuarioRepetidoException;
import br.ifpe.util.ConnectionFactory;

public class SolicitacaoDao {

	private Connection connection;

	public SolicitacaoDao() {
		try {
			this.connection = (Connection) new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// registrar solicitacao
	public void registrar(Solicitacao solicitacao) {

		try {
			String sql = "INSERT INTO solicitacao(fk_tipo_solicitacao, fk_usuario, complemento, anexos) VALUES (?,?,?,?)";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setInt(1, solicitacao.getTipoSolicitacao().getId());
			stmt.setInt(2, solicitacao.getUsuario().getId());
			stmt.setString(3, solicitacao.getComplemento());
			stmt.setString(4, solicitacao.getAnexos());

			stmt.execute();
			connection.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// montar objeto
	private Solicitacao montarObjeto(ResultSet rs) throws SQLException {

		Solicitacao solicitacao = new Solicitacao();

		solicitacao.setId(rs.getInt("id"));
		solicitacao.setDataHora(rs.getTimestamp("data_hora"));
		solicitacao.setStatus(Status.valueOf(rs.getString("status")));

		// montando o objeto com a chave estrangeira
		UsuarioDao dao1 = new UsuarioDao();
		Usuario usuario = dao1.buscarPorId(rs.getInt("fk_usuario"));
		solicitacao.setUsuario(usuario);

		UsuarioDao dao2 = new UsuarioDao();
		Usuario usuarioEncaminhado = dao2.buscarPorId(rs.getInt("fk_usuario_encaminhado"));
		solicitacao.setUsuarioEncaminhado(usuarioEncaminhado);

		// montando o objeto com a chave estrangeira
		TipoSolicitacaoDao dao3 = new TipoSolicitacaoDao();
		TipoSolicitacao tipoSolicitacao = dao3.buscarPorId(rs.getInt("fk_tipo_solicitacao"));
		solicitacao.setTipoSolicitacao(tipoSolicitacao);

		return solicitacao;

	}

	// listar
	public List<Solicitacao> listar() {

		try {

			List<Solicitacao> listarSolicitacao = new ArrayList<Solicitacao>();
			String sql = "SELECT * FROM solicitacao,usuario,tipo_solicitacao "
					+ "WHERE usuario.id = fk_usuario and tipo_solicitacao.id = fk_tipo_solicitacao and solicitacao.excluido = TRUE;";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				listarSolicitacao.add(montarObjeto(rs));
			}

			rs.close();
			stmt.close();
			connection.close();

			return listarSolicitacao;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// este metodo retorna a utima solicitacao feita e é usado em registrar
	// ocorrencia
	public Solicitacao obterUltimaSolicitacao() {

		try {

			Solicitacao solicitacao = null;
			String sql = "SELECT * FROM solicitacao ORDER BY id desc";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				solicitacao = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
			connection.close();

			return solicitacao;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// esrte metodo retorna um objeto
	public Solicitacao buscarPorId(int id) {

		try {

			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM solicitacao WHERE id = ?");
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			Solicitacao solicitacao = new Solicitacao();

			if (rs.next()) {
				solicitacao = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
			connection.close();

			return solicitacao;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// remover logico
	public void removerLogico(int id) {

		try {

			String sql = "UPDATE solicitacao SET excluido = FALSE  WHERE id = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, id);

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//
	public List<Solicitacao> listarPorId(Usuario usuario) {

		try {

			List<Solicitacao> listarSolicitacao = new ArrayList<Solicitacao>();
			PreparedStatement stmt = null;

			String sql = null;

			if (usuario.getPerfil().equals(Perfil.CRAD)) {
				sql = "SELECT * FROM solicitacao,usuario,tipo_solicitacao "
						+ "WHERE usuario.id = fk_usuario and tipo_solicitacao.id = fk_tipo_solicitacao and solicitacao.excluido = TRUE;";
				stmt = (PreparedStatement) connection.prepareStatement(sql);

			}
			if (usuario.getPerfil().equals(Perfil.PROFESSOR)) {
				sql = "SELECT * FROM solicitacao,usuario,tipo_solicitacao "
						+ "WHERE usuario.id = fk_usuario and tipo_solicitacao.id = fk_tipo_solicitacao and fk_usuario_encaminhado = ?;";
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setInt(1, usuario.getId());
			} else {
				sql = "SELECT * FROM solicitacao,usuario,tipo_solicitacao "
						+ "WHERE usuario.id = fk_usuario and tipo_solicitacao.id = fk_tipo_solicitacao and usuario.id = ?;";
				stmt = (PreparedStatement) connection.prepareStatement(sql);
				stmt.setInt(1, usuario.getId());
			}

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				listarSolicitacao.add(montarObjeto(rs));
			}

			rs.close();
			stmt.close();
			connection.close();

			return listarSolicitacao;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updateEncaminhar(Solicitacao solicitacao) {
		
		
		String sql = "UPDATE solicitacao SET fk_usuario_encaminhado=? WHERE id=?";
		PreparedStatement stmt;

		try {
			stmt = connection.prepareStatement(sql);

			stmt.setInt(1, solicitacao.getUsuarioEncaminhado().getId());
			// stmt.setString(2, solicitacao.getParecer());
			stmt.setInt(2, solicitacao.getId());

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}// fim
