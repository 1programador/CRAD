package br.ifpe.testes;

import org.junit.Test;

import br.ifpe.basicas.TipoSolicitacao;
import br.ifpe.dao.TipoSolicitacaoDao;
import br.ifpe.dao.UsuarioRepetidoException;

public class testeUsuario {

	@Test
	public void incluirUsuair() throws UsuarioRepetidoException {
		
		TipoSolicitacao tipo = new TipoSolicitacao();
		
		tipo.setDescricao("Boletim Escolar");
		tipo.setAnexo(true);
		tipo.setStatus(true);
		tipo.setDocumentos("abc");
		tipo.setComplemento(true);
		
		TipoSolicitacaoDao dao = new TipoSolicitacaoDao();
		
		dao.inserir(tipo);
		

	}

}
