package br.ifpe.converter;

import org.springframework.core.convert.converter.Converter;

import br.ifpe.basicas.Usuario;
import br.ifpe.dao.UsuarioDao;

public class UsuarioConverter implements Converter <String, Usuario>{

	public Usuario convert(String id){
		// este if verifica se categoria produto foi preenchida
				if (id != null && !id.equals("")) {
					UsuarioDao dao = new UsuarioDao();
					return dao.buscarPorId(Integer.valueOf(id));
				} 
				else 
					return null;
				
	}
}
