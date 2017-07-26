package br.ifpe.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.excecoes.TipoSolicitacaoRepitidaException;
import br.ifpe.util.ConnectionFactory;

public class TipoSolicitacaoDao {

	private Connection connection;

	public TipoSolicitacaoDao() {
		try {
			this.connection = (Connection) new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

//	inserir
	public void inserir(TipoSolicitacao tipo) throws TipoSolicitacaoRepitidaException {
		try {
			String sql = "INSERT INTO tipo_solicitacao(descricao, anexo, documentos, complemento) VALUES (?, ?, ?,?)";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1, tipo.getDescricao());
			stmt.setBoolean(2, tipo.getAnexo());
			stmt.setString(3, tipo.getDocumentos());
			stmt.setBoolean(4, tipo.getComplemento());

			stmt.execute();
			connection.close();

		} catch (SQLIntegrityConstraintViolationException e) {
			// esta exceção é esclusiva para violação de chave unica
			throw new TipoSolicitacaoRepitidaException(e);
		}

		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<TipoSolicitacao> listar() {

		try {

			List<TipoSolicitacao> listarTipoSolicitacao = new ArrayList<TipoSolicitacao>();
			String sql = "SELECT * FROM tipo_solicitacao ORDER BY descricao";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				TipoSolicitacao tipoSolicitacao = new TipoSolicitacao();

				tipoSolicitacao.setId(rs.getInt("id"));
				tipoSolicitacao.setDescricao(rs.getString("descricao"));
				tipoSolicitacao.setDocumentos(rs.getString("documentos"));

				listarTipoSolicitacao.add(tipoSolicitacao);
			}

			rs.close();
			stmt.close();
			connection.close();

			return listarTipoSolicitacao;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

//	remover logico
	public void removerLogico(int id) {

		try {

			String sql = "UPDATE tipo_solicitacao SET status = FALSE WHERE id = ?";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setInt(1, id);

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//montar objeto
		private TipoSolicitacao montarObjeto(ResultSet rs) throws SQLException {

			TipoSolicitacao tipoSolicitacao = new TipoSolicitacao();

			tipoSolicitacao.setId(rs.getInt("id"));
			tipoSolicitacao.setDescricao(rs.getString("descricao"));
			tipoSolicitacao.setStatus(rs.getBoolean("status"));
			tipoSolicitacao.setAnexo(rs.getBoolean("anexo"));
			tipoSolicitacao.setDocumentos(rs.getString("documentos"));
			tipoSolicitacao.setComplemento(rs.getBoolean("complemento"));
			
			return tipoSolicitacao;
		}
	
		// listar usuario
		public List<TipoSolicitacao> listarTipoSolicitacao() {

			try {

				List<TipoSolicitacao> listarTipoSolicitacao = new ArrayList<TipoSolicitacao>();
				String sql = "SELECT * FROM tipo_solicitacao  WHERE status=true ORDER BY descricao";
				PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					listarTipoSolicitacao.add(montarObjeto(rs));
				}

				rs.close();
				stmt.close();
				connection.close();

				return listarTipoSolicitacao;

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}	
}//fim
