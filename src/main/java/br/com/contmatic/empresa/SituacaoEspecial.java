package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.util.Datas.definirData;
import static br.com.contmatic.empresa.util.Datas.validarIntervalo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SituacaoEspecial {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public SituacaoEspecial(String status, String data) {
		this.setStatus(status);
		this.setData(data);
	}

	private String status;

	private Date data;
	
	private String usuario;

	private Date dataAlteracao;

	private Date dataCadastro;

	public String getSitEspecial() {
		return status;
	}

	public void setStatus(String status) {
		this.statusNaoDeveSerNulo(status);
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public void setData(int year, int month, int date) {
		validarIntervalo(definirData(year,month,date));
		this.data = definirData(year,month,date);
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

	public void setDataAlteracao(int year, int month, int date) {
		validarIntervalo(dataAlteracao);
		this.dataAlteracao = definirData(year,month,date);
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(int year, int month, int date) {
		validarIntervalo(dataCadastro);
		this.dataCadastro = definirData(year,month,date);
	}
	
	private void usuarioNaoDeveSerNulo(String usuario) {
		if(usuario == null) {
			throw new IllegalArgumentException("Usuario Não Deve Ser Nulo");
		}
	}

	private void statusNaoDeveSerNulo(String status) {
		if (status == null) {
			throw new IllegalArgumentException("Situação especial não deve ser nula");
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
		SituacaoEspecial other = (SituacaoEspecial) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SituacaoEspecial [SituaçãoEspecial=" + status + ", DataSituaçãoEspecial=" + data + "]";
	}
}
