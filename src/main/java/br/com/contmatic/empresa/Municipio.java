package br.com.contmatic.empresa;

public class Municipio {
	
	public Municipio() {}
	
	public Municipio(String municipio, String uf) {
		this.municipio = municipio;
		this.uf = uf;
	}

	private String municipio;
	
	private String uf;
	
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
	
	private void municipioDaEmpresaNaoDeveSerNulo(String municipio) {
		if(municipio == null) {
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
		if(uf == null) {
			throw new IllegalArgumentException("O UF Da Empresa não deve ser nulo");
		}
	}

	@Override
	public String toString() {
		return "Municipio [municipio=" + municipio + ", uf=" + uf + "]";
	}
	
}
