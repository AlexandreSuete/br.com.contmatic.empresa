package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.util.Datas.validarIntervalo;

import java.util.Date;

public class Municipio {

	private String cidade;

	private String uf;

	private String usuario;

	private Date dataAlteracao;

	private Date dataCadastro;

	public Municipio(String municipio, String uf) {
		this.setMunicipio(municipio);
		this.setUf(uf);
	}
	
	public Municipio(String cidade) {
		this.cidade = cidade;
	}

	public String getMunicipio() {
		return cidade;
	}

	public void setMunicipio(String municipio) {
		this.municipioDaEmpresaNaoDeveSerNulo(municipio);
		this.cidade = municipio;
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
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
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
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Municipio [municipio=" + cidade + ", uf=" + uf + "]";
	}
}
