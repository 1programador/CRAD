package br.ifpe.dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.ifpe.basicas.TipoSolicitacao;
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
	
	
	public void inserir(TipoSolicitacao tipo) {
		try {
			String sql = "INSERT INTO tipo_solicitacao(descricao, anexo, documentos, complemento) VALUES (?,?,?,?)";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setString(1, tipo.getDescricao());
			stmt.setBoolean(2, tipo.isAnexo());
			stmt.setString(3, tipo.getDocumentos());
			stmt.setBoolean(4, tipo.isComplemento());
			

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
