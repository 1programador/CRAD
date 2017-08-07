package br.ifpe.basicas;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Solicitacao {

	
	private int id;
	private Date dataHora;
	private Status status;
	@NotNull(message="Informe o Usuario")
	private Usuario usuario;
	@NotNull(message="Informe a solicitação")
	private TipoSolicitacao tipoSolicitacao;
	
	public Solicitacao(int id,Date dataHora,Status status, Usuario usuario, TipoSolicitacao tipoSolicitacao){
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.status = status;
		this.usuario = usuario;
		this.tipoSolicitacao = tipoSolicitacao;
	}
	
	public Solicitacao(){
		
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
