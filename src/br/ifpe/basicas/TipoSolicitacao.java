package br.ifpe.basicas;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class TipoSolicitacao {

	private int id;
	@Size(min=5, message="A descrição deve ter no minimo 5 caracteres!")
	private String descricao;
	private boolean excluido;
	@NotNull(message="Campo obrigatorio!")
	private Boolean temAnexo;
	private String listaDocumentos;
	@NotNull(message="Campo obrigatorio!")
	private Boolean temComplemento;

	public TipoSolicitacao(int id, String descricao, boolean status, boolean anexo, String documentos,
			boolean complemento) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.excluido = excluido;
		this.temAnexo = temAnexo;
		this.listaDocumentos = listaDocumentos;
		this.temComplemento = temComplemento;
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

	public boolean isExcluido() {
		return excluido;
	}

	public void setExcluido(boolean excluido) {
		this.excluido = excluido;
	}

	public Boolean getTemAnexo() {
		return temAnexo;
	}

	public void setTemAnexo(Boolean temAnexo) {
		this.temAnexo = temAnexo;
	}

	public String getListaDocumentos() {
		return listaDocumentos;
	}

	public void setListaDocumentos(String listaDocumentos) {
		this.listaDocumentos = listaDocumentos;
	}

	public Boolean getTemComplemento() {
		return temComplemento;
	}

	public void setTemComplemento(Boolean temComplemento) {
		this.temComplemento = temComplemento;
	}

}
