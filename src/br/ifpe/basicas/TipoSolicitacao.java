package br.ifpe.basicas;

public class TipoSolicitacao {

	private int codigo;
	private String descricao;
	private boolean status;
	private boolean anexo;
	private String documentos;
	private boolean complemento;

	public TipoSolicitacao(int codigo, String descricao, boolean status, boolean anexo, String documentos,
			boolean complemento) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.status = status;
		this.anexo = anexo;
		this.documentos = documentos;
		this.complemento = complemento;
	}

	public TipoSolicitacao() {

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

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isAnexo() {
		return anexo;
	}

	public void setAnexo(boolean anexo) {
		this.anexo = anexo;
	}

	public String getDocumentos() {
		return documentos;
	}

	public void setDocumentos(String documentos) {
		this.documentos = documentos;
	}

	public boolean isComplemento() {
		return complemento;
	}

	public void setComplemento(boolean complemento) {
		this.complemento = complemento;
	}

}
