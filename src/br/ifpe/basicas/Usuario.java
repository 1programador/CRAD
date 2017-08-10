package br.ifpe.basicas;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




public class Usuario {

	private int id;
	private boolean excluido;
	@Size(min = 3, max = 50, message="O nome deve ter no minimo 3 caracteres!")
	private String nome;
	@Size(min = 13, max = 15, message="A Matricula deve ter no minimo 13 caracteres!")
	private String matricula;
	@NotNull(message="Informe o perfil do Usuario")
	private Perfil perfil;

	public Usuario(int id, boolean status, String nome, String matricula, Perfil perfil) {
		super();
		this.id = id;
		this.excluido = excluido;
		this.nome = nome;
		this.matricula = matricula;
		this.perfil = perfil;
	}

	public Usuario() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public boolean isExcluido() {
		return excluido;
	}

	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

}
