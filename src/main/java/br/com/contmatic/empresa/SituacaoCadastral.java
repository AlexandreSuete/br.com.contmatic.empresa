package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.util.Constantes.STRING_MAX_LENGTH;
import static br.com.contmatic.empresa.util.Datas.validarIntervalo;

import java.util.Date;

public class SituacaoCadastral {

	private String motivo;

	private String status;

	private Date data;

	private String usuario;

	private Date dataAlteracao;

	private Date dataCadastro;

	public SituacaoCadastral(String motivo, String status, Date data) {
		this.setMotivo(motivo);
		this.setStatus(status);
		this.setData(data);
	}

	public SituacaoCadastral(String status) {
		this.status = status;
	}

	public Date getDataSituacaoCadastral() {
		return data;
	}

	public void setData(Date data) {
		validarIntervalo(data);
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.statusNaoDeveSerNulo(status);
		this.statusNaoDeveUltrapassarOLimiteDeCaracteres(status);
		this.status = status;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivoNaoDeveSerNulo(motivo);
		this.motivoNaoDeveUltrapassarLimiteDeCaracteres(motivo);
		this.motivo = motivo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		usuarioNaoDeveSerNulo(usuario);
		this.usuario = usuario;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date data) {
		validarIntervalo(data);
		this.dataAlteracao = data;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date data) {
		validarIntervalo(data);
		this.dataCadastro = data;
	}

	private void usuarioNaoDeveSerNulo(String usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Usuario Não Deve Ser Nulo");
		}
	}

	private void statusNaoDeveSerNulo(String status) {
		if (status == null) {
			throw new IllegalArgumentException("A Situação Cadastral não deve ser nula");
		}
	}

	private void motivoNaoDeveUltrapassarLimiteDeCaracteres(String motivo) {
		if (motivo.length() > STRING_MAX_LENGTH) {
			throw new IllegalArgumentException("O Motivo da Situação Cadastral não deve ultrapassar 255 caracteres");
		}
	}

	private void motivoNaoDeveSerNulo(String motivo) {
		if (motivo == null) {
			throw new IllegalArgumentException("O Motivo da Situação Cadastral não deve ser nulo");
		}
	}

	private void statusNaoDeveUltrapassarOLimiteDeCaracteres(String status) {
		if (status.length() > STRING_MAX_LENGTH) {
			throw new IllegalArgumentException("A Situação Cadastral não deve ultrapassar 255 caracteres");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SituacaoCadastral other = (SituacaoCadastral) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SituacaoCadastral [motivo=" + motivo + ", status=" + status + ", data=" + data + "]";
	}
}
