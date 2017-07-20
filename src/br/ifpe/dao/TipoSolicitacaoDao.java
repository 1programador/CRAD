package br.ifpe.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
import java.sql.SQLIntegrityConstraintViolationException;
>>>>>>> 7ebac350fca2536b0a8fecd12aee9048595d1d87

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.basicas.Usuario;
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
	
	
	public void inserir(TipoSolicitacao tipo) throws TipoSolicitacaoRepitidaException {
		try {
			String sql = "INSERT INTO tipo_solicitacao(descricao, anexo, documentos, complemento) VALUES (?, ?, ?,?)";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setString(1, tipo.getDescricao());
			stmt.setBoolean(2, tipo.isAnexo());
			stmt.setString(3, tipo.getDocumentos());
			stmt.setBoolean(4, tipo.isComplemento());
			

			stmt.execute();
			connection.close();

		}catch(SQLIntegrityConstraintViolationException e){
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
	
    public void remover(int id) {

	try {

	   

	    String sql = "DELETE FROM servico WHERE id = ?";
	    PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
	    stmt.setInt(1, id);

	    stmt.execute();
	    connection.close();

	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }
}
