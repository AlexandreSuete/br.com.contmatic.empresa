package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.util.Constantes.STRING_MAX_LENGTH;
import static br.com.contmatic.empresa.util.Datas.validarIntervalo;

public class SituacaoCadastral {
	
	private String motivo;
	
	private String status;
	
	private String data;
	
	public SituacaoCadastral() {}
	
	public SituacaoCadastral(String motivoSitCadastral, String situacaoCadastral, String dataSituacaoCadastral) {
		this.motivo = motivoSitCadastral;
		this.status = situacaoCadastral;
		this.data = dataSituacaoCadastral;
	}

	public String getDataSituacaoCadastral() {
		return data;
	}

	public void setData(int dia, int mes, int ano) {
		validarIntervalo(dia, mes, ano);
		String data = dia + "/" + mes + "/" + ano;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.situacaoCadastralNaoDeveUltrapassarLimiteDeCaracteres();
		this.situacaoCadastralNaoDeveSerNula(status);
		this.status = status;
	}
	
	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivoSituacaoCadastralNaoDeveUltrapassarLimiteDeCaracteres(motivo);
		this.motivoSituacaoCadastralNaoDeveSerNulo(motivo);
		this.motivo = motivo;
	}
	
	private void situacaoCadastralNaoDeveSerNula(String situacaoCadastral) {
		if(situacaoCadastral == null) {
			throw new IllegalArgumentException("A Situação Cadastral não deve ser nula");
		}
	}
	
	private void motivoSituacaoCadastralNaoDeveUltrapassarLimiteDeCaracteres(String motivoSitCadastral) {
		if (motivoSitCadastral.length() > STRING_MAX_LENGTH) {
			throw new IllegalArgumentException("O Motivo da Situação Cadastral não deve ultrapassar 255 caracteres");
		}
	}
	
	private void motivoSituacaoCadastralNaoDeveSerNulo(String motivoSitCadastral) {
		if(motivoSitCadastral == null) {
			throw new IllegalArgumentException("O Motivo da Situação Cadastral não deve ser nulo");
		}
	}
	
	private void situacaoCadastralNaoDeveUltrapassarLimiteDeCaracteres() {
		if (status.length() > STRING_MAX_LENGTH) {
			throw new IllegalArgumentException("A Situação Cadastral não deve ultrapassar 255 caracteres");
		}
	}

	@Override
	public String toString() {
		return "SituacaoCadastral [motivo=" + motivo + ", status=" + status + ", data=" + data + "]";
	}

}
