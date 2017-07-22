package br.ifpe.testes;

import org.junit.Test;

import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.dao.TipoSolicitacaoDao;
import br.ifpe.dao.TipoSolicitacaoRepitidaException;
import br.ifpe.dao.UsuarioRepetidoException;

public class testeUsuario {

	@Test
	public void incluirUsuair() throws UsuarioRepetidoException, TipoSolicitacaoRepitidaException {
		
		TipoSolicitacao tipo = new TipoSolicitacao();
		
		tipo.setDescricao("Boletim Escol");
		tipo.setAnexo(true);
		tipo.setStatus(true);
		tipo.setDocumentos("abc");
		tipo.setComplemento(true);
		
		TipoSolicitacaoDao dao = new TipoSolicitacaoDao();
		
		dao.inserir(tipo);
		

	}

}
