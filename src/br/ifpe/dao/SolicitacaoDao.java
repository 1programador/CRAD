package br.ifpe.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.ifpe.basicas.Solicitacao;
import br.ifpe.basicas.Status;
import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.basicas.Usuario;
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

	//montar objeto
		private Solicitacao montarObjeto(ResultSet rs) throws SQLException {

			Solicitacao solicitacao = new Solicitacao();

			solicitacao.setId(rs.getInt("id"));
			solicitacao.setDataHora(rs.getDate("data_hora"));
			solicitacao.setStatus(Status.valueOf(rs.getString("status")));
//			montando o objeto com a chave estrangeira
			UsuarioDao dao1 = new UsuarioDao();
			Usuario usuario = dao1.buscarPorId(rs.getInt("fk_usuario"));
			solicitacao.setUsuario(usuario);
//			montando o objeto com a chave estrangeira			
			TipoSolicitacaoDao dao2 = new TipoSolicitacaoDao();
			TipoSolicitacao tipoSolicitacao = dao2.buscarPorId(rs.getInt("fk_tipo_solicitacao"));
			solicitacao.setTipoSolicitacao(tipoSolicitacao);
			
			return solicitacao;
			
		}
	
//	listar
		public List<Solicitacao> listar() {

			try {

				List<Solicitacao> listarSolicitacao = new ArrayList<Solicitacao>();
				String sql = "SELECT * FROM solicitacao,usuario,tipo_solicitacao "
							+"WHERE usuario.id = fk_usuario and tipo_solicitacao.id = fk_tipo_solicitacao and solicitacao.excluido = TRUE;"	;
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
		
//		
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
		
		
//		remover logico
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
}//fim
