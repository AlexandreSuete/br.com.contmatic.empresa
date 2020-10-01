package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.util.Constantes.*;
import static br.com.contmatic.empresa.util.Datas.definirData;
import static br.com.contmatic.empresa.util.Datas.validarIntervalo;

import java.util.Date;

public class Atividade {

	private String codigo;

	private String descricao;

	private Atividade secundario;

	private String usuario;

	private Date dataAlteracao;

	private Date dataCadastro;

	public Atividade(String codigo, String descricao) {
		this.setCodigo(codigo);
		this.setDescricao(descricao);
	}

	public String getCodAtividade() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigoDeAtividadeDaEmpresaNaoDeveSerNulo(codigo);
		this.codigoDeAtividadeDeveConter7Digitos(codigo);
		this.codigoDeAtividadeNaoDeveConterLetras(codigo);
		this.codigoDeAtividadeNaoDeveConterEspacosEmBranco(codigo);

		this.codigo = codigo;
	}

	public String getAtividade() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.atividadeDaEmpresaNaoDeveSerNula(descricao);
		this.atividadeNaoDeveUltrapassarLimiteDeCaracteres(descricao);
		this.descricao = descricao;
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

	public String getSecundario() {
		return secundario.toString();
	}

	public void setSecundario(String codigo, String descricao) {
		secundario = new Atividade(codigo, descricao);
	}

	private void usuarioNaoDeveSerNulo(String usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Usuario Não Deve Ser Nulo");
		}
	}

	private void codigoDeAtividadeNaoDeveConterLetras(String codigo) {
		if (codigo.substring(CODIGO_INITI_LENGTH, CODIGO_ATIVIDADE).matches("[A-Z|a-z]*")) {
			throw new IllegalArgumentException("O Codigo de Atividade da Empresa não pode conter letras");
		}
	}

	private void codigoDeAtividadeNaoDeveConterEspacosEmBranco(String codigo) {
		if (codigo.substring(CODIGO_INITI_LENGTH, CODIGO_ATIVIDADE).matches(" ")) {
			throw new IllegalArgumentException("O Codigo de Atividade da Empresa não pode conter espaços em branco");
		}
	}

	private void atividadeDaEmpresaNaoDeveSerNula(String descricao) {
		if (descricao == null) {
			throw new IllegalArgumentException("A Atividade exercida pela empresa não deve ser nula");
		}
	}

	private void codigoDeAtividadeDaEmpresaNaoDeveSerNulo(String codigo) {
		if (codigo == null) {
			throw new IllegalArgumentException("O Codigo Da Atividade exercida pela empresa não pode ser nulo");
		}
	}

	private void codigoDeAtividadeDeveConter7Digitos(String descricao) {
		if (descricao.length() != CODIGO_ATIVIDADE_LENGTH) {
			throw new IllegalArgumentException("O Codigo de Atividade da empresa deve conter 7 digitos");
		}
	}

	private void atividadeNaoDeveUltrapassarLimiteDeCaracteres(String descricao) {
		if (descricao.length() > STRING_MAX_LENGTH) {
			throw new IllegalArgumentException("A Atividade da Empresa não deve ultrapassar 255 digitos");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		return true;
	}

	@Override
	public String toString() {
		return "Atividade [codigo=" + codigo + ", descricao=" + descricao + "]";
	}

}
