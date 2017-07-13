package br.ifpe.dao;

import java.sql.SQLIntegrityConstraintViolationException;

public class UsuarioRepetidoException extends Exception {

	public UsuarioRepetidoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioRepetidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UsuarioRepetidoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UsuarioRepetidoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UsuarioRepetidoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	

}
