package br.ifpe.testes;

import org.junit.Test;
import br.ifpe.basicas.Perfil;
import br.ifpe.basicas.Usuario;
import br.ifpe.dao.UsuarioDao;

public class testeUsuario {
	
	@Test
	public void incluirUsuair(){
		
	Usuario usuario = new Usuario("Ruggery", "tijg04", Perfil.ALUNO);

	UsuarioDao dao = new UsuarioDao();
	
	dao.inserir(usuario);
	
	}
	

}
