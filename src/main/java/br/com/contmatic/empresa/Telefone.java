package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.util.Datas.definirData;
import static br.com.contmatic.empresa.util.Datas.validarIntervalo;

import java.util.Date;

public class Telefone {

	private int ddi;

	private int ddd;

	private String telefone;

	private String usuario;

	private Date dataAlteracao;

	private Date dataCadastro;

	public Telefone(int ddi, int ddd, String telefone) {
		this.setDdi(ddi);
		this.setDdd(ddd);
		this.telefone = telefone;
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
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefoneNaoDeveSerNulo(telefone);
		this.validarTelefone(telefone);
		this.telefoneNaoDeveConterLetras(telefone);
		this.telefone = telefone;
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

	private void telefoneNaoDeveConterLetras(String telefone) {
		if (telefone.substring(0, 9).matches("[A-Z|a-z]*")) {
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
		if (telefone.length() < 8 || telefone.length() > 9) {
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
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [ddi=" + ddi + ", ddd=" + ddd + ", telefone=" + telefone + "]";
	}
}
