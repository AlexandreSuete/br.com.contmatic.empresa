package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.util.Datas.validarIntervalo;

import java.util.Date;

public class Telefone {

	private int ddi;

	private int ddd;

	private String numTelefone;

	private String usuario;

	private Date dataAlteracao;

	private Date dataCadastro;

	public Telefone(int ddi, int ddd, String telefone) {
		this.setDdi(ddi);
		this.setDdd(ddd);
		this.setTelefone(telefone);
	}

	public int getDdi() {
		return ddi;
	}

	public void setDdi(int ddi) {
		this.validarDDI(ddi);
		this.ddi = ddi;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.validarDDD(ddd);
		this.ddd = ddd;
	}

	public String getTelefone() {
		return numTelefone;
	}

	public void setTelefone(String telefone) {
		this.telefoneNaoDeveSerNulo(telefone);
		this.validarTelefone(telefone);
		this.telefoneNaoDeveConterLetras(telefone);
		this.numTelefone = telefone;
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

	private void telefoneNaoDeveConterLetras(String telefone) {
		if (telefone.substring(0, 8).matches("[A-Z|a-z]*")) {
			throw new IllegalArgumentException("O Telefone não deve conter letras");
		}
	}

	private void validarDDI(int ddi) {
		if (ddi < 1 || ddi > 999) {
			throw new IllegalArgumentException("O DDI digitado não é valido");
		}
	}

	private void usuarioNaoDeveSerNulo(String usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Usuario Não Deve Ser Nulo");
		}
	}

	private void validarDDD(int ddd) {
		if (ddd < 11 || ddd > 99) {
			throw new IllegalArgumentException("O DDD digitado não é valido");
		}
	}

	private void validarTelefone(String telefone) {
		if (telefone.length() != 8) {
			throw new IllegalArgumentException("O telefone digitado não é valido");
		}
	}

	private void telefoneNaoDeveSerNulo(String telefone) {
		if (telefone == null) {
			throw new IllegalArgumentException("O Telefone não deve ser nulo");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numTelefone == null) ? 0 : numTelefone.hashCode());
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
		Telefone other = (Telefone) obj;
		if (numTelefone == null) {
			if (other.numTelefone != null)
				return false;
		} else if (!numTelefone.equals(other.numTelefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [ddi=" + ddi + ", ddd=" + ddd + ", telefone=" + numTelefone + "]";
	}
}
