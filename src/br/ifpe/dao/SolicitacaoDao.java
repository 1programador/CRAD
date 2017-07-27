package br.ifpe.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.ifpe.basicas.Solicitacao;
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

//	registrar solicitacao
	public void registrar(Solicitacao solicitacao){
		
		try {
			String sql = "INSERT INTO solicitacao(fk_tipo_solicitacao, fk_usuario) VALUES (?,?)";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setInt(1, solicitacao.getTipoSolicitacao().getId());
			stmt.setInt(2, solicitacao.getUsuario().getId());

			stmt.execute();
			connection.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


}//fim
