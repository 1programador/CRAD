package br.ifpe.testes;


import org.junit.Test;

import br.ifpe.basicas.Solicitacao;
import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.basicas.Usuario;
import br.ifpe.dao.SolicitacaoDao;

public class TesteSolicitacaoDao {

	private SolicitacaoDao dao = new SolicitacaoDao();
	
	@Test
	public void testRegistrar() {
		Solicitacao sol = new Solicitacao();
		TipoSolicitacao ts = new TipoSolicitacao();
		ts.setId(1);
		
		Usuario us = new Usuario();
		us.setId(1);
	
		sol.setTipoSolicitacao(ts);
		sol.setUsuario(us);
		
		dao.registrar(sol);
	}

}
