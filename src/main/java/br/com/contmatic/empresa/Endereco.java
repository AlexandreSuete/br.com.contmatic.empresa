package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.util.Constantes.*;
import static br.com.contmatic.empresa.util.Datas.formatacaoDeData;
import static br.com.contmatic.empresa.util.Datas.validarIntervalo;

import java.util.Date;


public class Endereco {

	private String logradouro;

	private int numLogradouro;

	private String complemento;

	private Municipio municipio;
	
	private String bairro;

	private String cep;
	
	private String usuario;

	private Date dataAlteracao;

	private Date dataCadastro;

	public Endereco(String logradouro,Municipio municipio, String bairro,
			String cep) {
		this.setLogradouro(logradouro);
		this.setMunicipio(municipio);
		this.setBairro(bairro);
		this.setCep(cep);
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cepNaoDeveSerNulo(cep);
		this.cepDeveConter8Digitos(cep);
		this.cep = cep;
	}
	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairroNaoDeveSerNulo(bairro);
		this.bairro = bairro;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public int getNumLogradouro() {
		return numLogradouro;
	}

	public void setNumLogradouro(int numLogradouro) {
		this.numeroDoLogradouroNaoDeveSerNegativo(numLogradouro);
		this.numeroDoLogradouroNaoDeveUltrapassar6Digitos(numLogradouro);
		this.numLogradouro = numLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouroNaoDeveSerNulo(logradouro);
		this.logradouroTamanhoMaximo(logradouro);
		this.logradouro = logradouro;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
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

	public void setDataAlteracao(String dataAlteracao) {
		validarIntervalo(formatacaoDeData(dataAlteracao));
		this.dataAlteracao = formatacaoDeData(dataAlteracao);
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		validarIntervalo(formatacaoDeData(dataCadastro));
		this.dataCadastro = formatacaoDeData(dataCadastro);
	}

	private void usuarioNaoDeveSerNulo(String usuario) {
		if(usuario == null) {
			throw new IllegalArgumentException("Usuario Não Deve Ser Nulo");
		}
	}

	private void logradouroTamanhoMaximo(String logradouro) {
		if(logradouro.length()>255) {
			throw new IllegalArgumentException("O logradouro não deve ultrapassar 255 caracteres abrevie se possivel");
		}
	}

	private void logradouroNaoDeveSerNulo(String logradouro) {
		if (logradouro == null) {
			throw new IllegalArgumentException("O logradouro da empresa não deve ser nulo");
		}
	}

	private void numeroDoLogradouroNaoDeveSerNegativo(int numLogradouro) {
		if (numLogradouro < NUMBER_MIN) {
			throw new IllegalArgumentException("O numero do logradouro não deve ser negativo");
		}
	}
	
	private void numeroDoLogradouroNaoDeveUltrapassar6Digitos(int numLogradouro) {
		if (numLogradouro > NUMBER_MAX) {
			throw new IllegalArgumentException("O Numero do logradouro não deve passar de 6 digitos");
		}
	}
	
	private void bairroNaoDeveSerNulo(String bairro) {
		if(bairro == null) {
			throw new IllegalArgumentException("O Bairro não deve ser nulo");
		}
	}
	
	private void cepDeveConter8Digitos(String cep) {
		if (cep.length()!=8){
			throw new IllegalArgumentException("O Numero CEP não deve passar de 8 digitos");
		}
	}

	private void cepNaoDeveSerNulo(String cep) {
		if(cep == null) {
			throw new IllegalArgumentException("Cep da empresa não deve ser nulo");
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + numLogradouro;
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
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (numLogradouro != other.numLogradouro)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", numLogradouro=" + numLogradouro + ", complemento="
				+ complemento + ", municipio=" + municipio + ", bairro=" + bairro + ", cep=" + cep + "]";
	}
}
