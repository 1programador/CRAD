package br.ifpe.basicas;

public class Usuario {

	private int id;
	private boolean status;
	private String nome;
	private String matricula;
	private Perfil perfil;

	public Usuario(int id, boolean status, String nome, String matricula, Perfil perfil) {
		super();
		this.id = id;
		this.status = status;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
