package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.util.Constantes.*;

public class Atividade {

	private String codigo;

	private String descricao;
	
	private Atividade secundario;

	public Atividade() {
	}

	public Atividade(String codAtividade, String atividade, String codSubAtividade, String subAtividade) {
		this.codigo = codAtividade;
		this.descricao = atividade;
		secundario = new Atividade();
	}

	public String getCodAtividade() {
		return codigo;
	}

	public void setCodAtividade(String codAtividade) {
		this.codigoDeAtividadeDaEmpresaNaoDeveSerNulo(codAtividade);
		this.codigoDeAtividadeDeveConter7Digitos(codAtividade);
		this.codigoDeAtividadeNaoDeveConterLetras(codAtividade);
		this.codigoDeAtividadeNaoDeveConterEspacosEmBranco(codAtividade);

		this.codigo = codAtividade;
	}

	public String getAtividade() {
		return descricao;
	}

	public void setAtividade(String atividade) {
		this.atividadeDaEmpresaNaoDeveSerNula(atividade);
		this.atividadeNaoDeveUltrapassarLimiteDeCaracteres(atividade);
		this.descricao = atividade;
	}

	private void codigoDeAtividadeNaoDeveConterLetras(String codAtividade) {
		if (codAtividade.substring(CODIGO_INITI_LENGTH, CODIGO_ATIVIDADE).matches("[A-Z|a-z]*")) {
			throw new IllegalArgumentException("O Codigo de Atividade da Empresa não pode conter letras");
		}
	}
	
	private void codigoDeAtividadeNaoDeveConterEspacosEmBranco(String codAtividade) {
		if (codAtividade.substring(CODIGO_INITI_LENGTH, CODIGO_ATIVIDADE).matches(" ")) {
			throw new IllegalArgumentException("O Codigo de Atividade da Empresa não pode conter espaços em branco");
		}
	}

	private void atividadeDaEmpresaNaoDeveSerNula(String atividade) {
		if (atividade == null) {
			throw new IllegalArgumentException("A Atividade exercida pela empresa não deve ser nula");
		}
	}

	private void codigoDeAtividadeDaEmpresaNaoDeveSerNulo(String codAtividade) {
		if (codAtividade == null) {
			throw new IllegalArgumentException("O Codigo Da Atividade exercida pela empresa não pode ser nulo");
		}
	}

	private void codigoDeAtividadeDeveConter7Digitos(String codAtividade) {
		if (codAtividade.length() != CODIGO_ATIVIDADE_LENGTH) {
			throw new IllegalArgumentException("O Codigo de Atividade da empresa deve conter 7 digitos");
		}
	}
	
	private void atividadeNaoDeveUltrapassarLimiteDeCaracteres(String atividade) {
		if(atividade.length()>STRING_MAX_LENGTH){
			throw new IllegalArgumentException("A Atividade da Empresa não deve ultrapassar 255 digitos");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((secundario == null) ? 0 : secundario.hashCode());
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
		Atividade other = (Atividade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (secundario == null) {
			if (other.secundario != null)
				return false;
		} else if (!secundario.equals(other.secundario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atividade [codigo=" + codigo + ", descricao=" + descricao + ", secundario=" + secundario + "]";
	}


}
