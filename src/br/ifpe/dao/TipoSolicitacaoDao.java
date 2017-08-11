package br.ifpe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import br.ifpe.basicas.Perfil;
import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.basicas.Usuario;
import br.ifpe.excecoes.TipoSolicitacaoRepetidaException;
import br.ifpe.excecoes.UsuarioRepetidoException;
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
	public void inserir(TipoSolicitacao tipo) throws TipoSolicitacaoRepetidaException {
		try {
			String sql = "INSERT INTO tipo_solicitacao(descricao, tem_anexo, lista_documentos, tem_complemento) VALUES (?, ?, ?,?)";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1, tipo.getDescricao());
			stmt.setBoolean(2, tipo.getTemAnexo());
			stmt.setString(3, tipo.getListaDocumentos());
			stmt.setBoolean(4, tipo.getTemComplemento());

			stmt.execute();
			connection.close();

		} catch (SQLIntegrityConstraintViolationException e) {
			// esta exceção é esclusiva para violação de chave unica
			throw new TipoSolicitacaoRepetidaException(e);
		}

		catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

//	listar
	public List<TipoSolicitacao> listar() {

		try {

			List<TipoSolicitacao> listarTipoSolicitacao = new ArrayList<TipoSolicitacao>();
			String sql = "SELECT * FROM tipo_solicitacao WHERE excluido = true ORDER BY descricao ";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				TipoSolicitacao tipoSolicitacao = new TipoSolicitacao();

				tipoSolicitacao.setId(rs.getInt("id"));
				tipoSolicitacao.setDescricao(rs.getString("descricao"));
				tipoSolicitacao.setListaDocumentos(rs.getString("lista_documentos"));

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

			String sql = "UPDATE tipo_solicitacao SET excluido = FALSE WHERE id = ?";
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
			tipoSolicitacao.setExcluido(rs.getBoolean("excluido"));
			tipoSolicitacao.setTemAnexo(rs.getBoolean("tem_anexo"));
			tipoSolicitacao.setListaDocumentos(rs.getString("lista_documentos"));
			tipoSolicitacao.setTemComplemento(rs.getBoolean("tem_complemento"));
			
			return tipoSolicitacao;
		}
	
		// listar Tipo de solicitacao
		public List<TipoSolicitacao> listarTipoSolicitacao() {

			try {

				List<TipoSolicitacao> listarTipoSolicitacao = new ArrayList<TipoSolicitacao>();
				String sql = "SELECT * FROM tipo_solicitacao  WHERE excluido=true ORDER BY descricao";
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
		
		//buscar por id
		public TipoSolicitacao buscarPorId(int id) {

		try {

			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM tipo_solicitacao WHERE id = ?");
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			TipoSolicitacao tipoSolicitacao = new TipoSolicitacao();

			if (rs.next()) {
				tipoSolicitacao = montarObjeto(rs);
			}

			rs.close();
			stmt.close();
			connection.close();

			return tipoSolicitacao;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
		
//		alterar incompleto
		public void alterarTipo(TipoSolicitacao tipoSolicitacao) throws TipoSolicitacaoRepetidaException {

			String sql = "UPDATE tipo_solicitacao SET descricao=?, lista_documentos=? WHERE id=?";
			PreparedStatement stmt;

			try {
				stmt = connection.prepareStatement(sql);

				stmt.setString(1, tipoSolicitacao.getDescricao());
				stmt.setString(2, tipoSolicitacao.getListaDocumentos());
				stmt.setInt(3, tipoSolicitacao.getId());

				stmt.execute();
				connection.close();

			}catch (SQLIntegrityConstraintViolationException e) {
				// esta exceção é esclusiva para violação de chave unica
				throw new RuntimeException(e);

			} 
			
			catch (SQLException e) {
				throw new TipoSolicitacaoRepetidaException(e);
			}
		}
		
}//fim
