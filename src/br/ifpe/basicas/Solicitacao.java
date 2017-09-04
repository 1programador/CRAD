package br.ifpe.basicas;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Solicitacao {

	private int id;
	private Date dataHora;
	private Status status;
	private String anexos;
	private String complemento;
	private String parecer;
	private Usuario usuarioEncaminhado;
	private Usuario usuario;
	@NotNull(message = "Informe a solicitação")
	private TipoSolicitacao tipoSolicitacao;

	public Solicitacao(int id, Date dataHora, Status status, String anexos, String complemento, String parecer,
			Usuario usuarioEncaminhado, Usuario usuario, TipoSolicitacao tipoSolicitacao) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.status = status;
		this.anexos = anexos;
		this.complemento = complemento;
		this.parecer = parecer;
		this.usuarioEncaminhado = usuarioEncaminhado;
		this.usuario = usuario;
		this.tipoSolicitacao = tipoSolicitacao;
	}

	public Solicitacao() {

	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public Usuario getUsuarioEncaminhado() {
		return usuarioEncaminhado;
	}

	public void setUsuarioEncaminhado(Usuario usuarioEncaminhado) {
		this.usuarioEncaminhado = usuarioEncaminhado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getAnexos() {
		return anexos;
	}

	public void setAnexos(String anexos) {
		this.anexos = anexos;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoSolicitacao getTipoSolicitacao() {
		return tipoSolicitacao;
	}

	public void setTipoSolicitacao(TipoSolicitacao tipoSolicitacao) {
		this.tipoSolicitacao = tipoSolicitacao;
	}

}
