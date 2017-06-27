package br.ifpe.dao;

import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.ifpe.basicas.Servico;
import br.ifpe.basicas.Usuario;
import br.ifpe.util.ConnectionFactory;

public class ServicoDao {

	private Connection connection;

	public ServicoDao() {
			try {
				this.connection = (Connection) new ConnectionFactory().getConnection();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	public void inserir(Servico servico) {
		try {
			String sql = "INSERT INTO servico(descricao, anexo, complemento) VALUES (?,?,?)";
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, servico.getDescricao());
			stmt.setBoolean(2, servico.getAnexo());
			stmt.setBoolean(3, servico.getComplemento());
			

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
