package br.ifpe.testes;

import org.junit.Test;
import br.ifpe.basicas.Perfil;
import br.ifpe.basicas.Usuario;
import br.ifpe.dao.UsuarioDao;
import br.ifpe.dao.UsuarioRepetidoException;

public class testeUsuario {
	
	@Test
	public void incluirUsuair() throws UsuarioRepetidoException{
		
	Usuario usuario = new Usuario("Ruggery", "tijg04", Perfil.ALUNO);

	UsuarioDao dao = new UsuarioDao();
	
	dao.inserir(usuario);
	
	}
	
	

}
