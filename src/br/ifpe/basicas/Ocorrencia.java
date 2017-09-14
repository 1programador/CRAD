package br.ifpe.basicas;

import java.util.Date;

public class Ocorrencia {

	// constante
	public static final String OCORRENCIA_SOLICITACAO_REGISTRADA = "Solicitação Registrada";
	public static final String OCORRENCIA_SOLICITACAO_ENCAMINHADA = "Solicitação encaminhada";
	public static final String OCORRENCIA_SOLICITACAO_EXCLUIDA = "Solicitação excluida";
	
	private int id;
	private String acao;
	private Date dataHora;
	private String parecer;
	private Usuario usuario;
	private Solicitacao solicitacao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

}
