package br.ifpe.converter;

import org.springframework.core.convert.converter.Converter;

import br.ifpe.basicas.Usuario;
import br.ifpe.dao.UsuarioDao;

public class UsuarioConverter implements Converter <String, Usuario>{

	public Usuario convert(String id){
		UsuarioDao dao = new UsuarioDao();
		return dao.buscarPorId(Integer.valueOf(id));
	}
}
