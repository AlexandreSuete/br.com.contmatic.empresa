package br.com.contmatic.empresa;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contato {

	private String email;

	private Telefone telefone;
	
	public Contato() {
	}

	public Contato(String email, Telefone telefone) {
		this.email = email;
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.emailDaEmpresaNaoDeveSerNulo(email);
		this.emailDaEmpresaDeveSerValido(email);
		this.email = email;
	}

	private void emailDaEmpresaNaoDeveSerNulo(String email) {
		if (email == null) {
			throw new IllegalArgumentException("Email da Empresa não deve ser nulo");
		}
	}

	private void emailDaEmpresaDeveSerValido(String email) {
		if (!this.validarEmail(email)) {
			throw new IllegalStateException("Este email não é valido");
		}
	}

	private boolean validarEmail(String email) {
		boolean isEmailIdValid = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isEmailIdValid = true;
			}
		}
		return isEmailIdValid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Contato other = (Contato) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contato [email=" + email + ", telefone=" + telefone + "]";
	}
}
