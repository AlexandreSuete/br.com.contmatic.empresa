package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.util.Datas.definirData;
import static br.com.contmatic.empresa.util.Datas.validarIntervalo;

import java.util.Date;

public class Municipio {

	private String municipio;

	private String uf;

	private String usuario;

	private Date dataAlteracao;

	private Date dataCadastro;

	public Municipio(String municipio, String uf) {
		this.setMunicipio(municipio);
		this.setUf(uf);
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipioDaEmpresaNaoDeveSerNulo(municipio);
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.ufDaEmpresaNaoDeveSerNulo(uf);
		this.ufDeveConter2Letras(uf);
		this.ufDeveConterApenasLetras(uf);
		this.uf = uf;
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
		this.dataAlteracao = definirData(year, month, date);
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(int year, int month, int date) {
		validarIntervalo(dataCadastro);
		this.dataCadastro = definirData(year, month, date);
	}

	private void usuarioNaoDeveSerNulo(String usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Usuario Não Deve Ser Nulo");
		}
	}

	private void municipioDaEmpresaNaoDeveSerNulo(String municipio) {
		if (municipio == null) {
			throw new IllegalArgumentException("O Municipio Da Empresa não deve ser nulo");
		}
	}

	private void ufDeveConterApenasLetras(String uf) {
		if (!uf.substring(0, 1).matches("[A-Z|a-z]*")) {
			throw new IllegalArgumentException("O UF da Empresa deve conter apenas letras");
		}
	}

	private void ufDeveConter2Letras(String uf) {
		if (uf.length() != 2) {
			throw new IllegalArgumentException("O UF da empresa deve conter 2 letras");
		}
	}

	private void ufDaEmpresaNaoDeveSerNulo(String uf) {
		if (uf == null) {
			throw new IllegalArgumentException("O UF Da Empresa não deve ser nulo");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((municipio == null) ? 0 : municipio.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		Municipio other = (Municipio) obj;
		if (municipio == null) {
			if (other.municipio != null)
				return false;
		} else if (!municipio.equals(other.municipio))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Municipio [municipio=" + municipio + ", uf=" + uf + "]";
	}
}
