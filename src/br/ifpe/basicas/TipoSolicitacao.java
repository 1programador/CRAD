package br.ifpe.basicas;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class TipoSolicitacao {

	private int id;
	@Size(min=5, max=10, message="A descrição deve ter no minimo 5 caracteres!")
	private String descricao;
	private boolean status;
	@NotNull(message="Campo obrigatorio!")
	private Boolean anexo;
	private String documentos;
	@NotNull(message="Campo obrigatorio!")
	private Boolean complemento;

	public TipoSolicitacao(int id, String descricao, boolean status, boolean anexo, String documentos,
			boolean complemento) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.status = status;
		this.anexo = anexo;
		this.documentos = documentos;
		this.complemento = complemento;
	}

	public TipoSolicitacao() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Boolean getAnexo() {
		return anexo;
	}

	public void setAnexo(Boolean anexo) {
		this.anexo = anexo;
	}

	public String getDocumentos() {
		return documentos;
	}

	public void setDocumentos(String documentos) {
		this.documentos = documentos;
	}

	public Boolean getComplemento() {
		return complemento;
	}

	public void setComplemento(Boolean complemento) {
		this.complemento = complemento;
	}

	

}
