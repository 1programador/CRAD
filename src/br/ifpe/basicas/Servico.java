package br.ifpe.basicas;

public class Servico {

	private int codigo;
	private String descricao;
	private boolean status;
	private boolean anexo;
	private boolean complemento;
	
	public Servico(int codigo, String descricao, boolean status, boolean anexo, boolean complemento){
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.status = status;
		this.anexo = anexo;
		this.complemento = complemento;
		
	}
	
	public Servico(){
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescicao(String descricao) {
		this.descricao = descricao;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean getAnexo() {
		return anexo;
	}

	public void setAnexo(boolean anexo) {
		this.anexo = anexo;
	}

	public boolean getComplemento() {
		return complemento;
	}

	public void setComplemento(boolean complemento) {
		this.complemento = complemento;
	}
	
}
