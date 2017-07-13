package br.ifpe.basicas;

public class Usuario {

	private int id;
	private String nome;
	private String matricula;
	private Perfil perfil;

	public Usuario(String nome, String matricula, Perfil perfil) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.perfil = perfil;
	}
	
	public Usuario(){
		
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
