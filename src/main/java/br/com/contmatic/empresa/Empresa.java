package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.util.Constantes.*;
import static br.com.contmatic.empresa.util.Datas.definirData;
import static br.com.contmatic.empresa.util.Datas.validarIntervalo;

import java.util.Date;

public class Empresa {

	private String cnpj;

	private String razaoSocial;

	private String nomeFantasia;

	private String codNatJuridica;

	private String natJuridica;

	private String porte;

	private Date dataAbertura;

	private String enteFederativo;

	private Contato contato;

	private Endereco endereco;

	private Atividade atividade;

	private SituacaoCadastral situacaoCadastral;

	private SituacaoEspecial situacaoEspecial;

	private String usuario;

	private Date dataAlteracao;

	private Date dataCadastro;

	private String ip;

	public Empresa(String cnpj, String razaoSocial, String nomeFantasia, String codNatJuridica, String natJuridica,
			String porte, int year, int month, int date, Contato contato, Endereco endereco, Atividade atividade,
			SituacaoCadastral situacaoCadastral) {
		this.setCnpj(cnpj);
		this.setRazaoSocial(razaoSocial);
		this.setNomeFantasia(nomeFantasia);
		this.setCodNatJuridica(codNatJuridica);
		this.setNatJuridica(natJuridica);
		this.setPorte(porte);
		this.setDataAbertura(year, month, date);
		this.setContato(contato);
		this.setEndereco(endereco);
		this.setAtividade(atividade);
		this.setSituacaoCadastral(situacaoCadastral);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpjNaoPodeSerNulo(cnpj);
		this.cnpjDeveConter14Digitos(cnpj);
		this.cnpjNãoPodeTerLetras(cnpj);
		this.cnpjNaoDeveConterEspacosEmBranco(cnpj);
		this.validarCnpj(cnpj);
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocialNaoDeveSerNula(razaoSocial);
		this.razaoSocialNaoDeveUltrapassarLimiteDeCaracteres(razaoSocial);
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasiaNaoDeveSerNulo(nomeFantasia);
		this.nomeFantasiaNaoDeveUltrapassarLimiteDeCaracteres(nomeFantasia);
		this.nomeFantasia = nomeFantasia;
	}

	public String getCodNatJuridica() {
		return codNatJuridica;
	}

	public void setCodNatJuridica(String codNatJuridica) {
		this.codigoDeNaturezaJuridicaNaoDeveSerNulo(codNatJuridica);
		this.codigoDeNaturezaJuridicaDeveConterApenas4Digitos(codNatJuridica);
		this.codigoDeNaturezaJuridicaNaoDeveConterLetras(codNatJuridica);
		this.codNatJuridica = codNatJuridica;
	}

	public String getNatJuridica() {
		return natJuridica;
	}

	public void setNatJuridica(String natJuridica) {
		this.naturezaJuridicaNaoDeveSerNula(natJuridica);
		this.naturezaJuridicaNaoDeveUltrapassarLimiteDeCaracteres(natJuridica);
		this.natJuridica = natJuridica;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porteDaEmpresaNaoDeveSerNulo(porte);
		this.porteNaoDeveUltrapassarLimiteDeCaracteres(porte);
		this.porte = porte;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(int year, int month, int date) {
		validarIntervalo(definirData(year, month, date));
		this.dataAbertura = definirData(year, month, date);
	}

	public String getEnteFederativo() {
		return enteFederativo;
	}

	public void setEnteFederativo(String enteFederativo) {
		this.enteFederativoNaoDeveUltrapassarLimiteDeCaracteres(enteFederativo);
		this.enteFederativo = enteFederativo;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contatoNaoDeveSerNulo(contato);
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.enderecoNaoDeveSerNulo(endereco);
		this.endereco = endereco;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividadeDaEmpresaNaoDeveSerNula(atividade);
		this.atividade = atividade;
	}

	public SituacaoCadastral getSituacaoCadastral() {
		return situacaoCadastral;
	}

	public void setSituacaoCadastral(SituacaoCadastral situacaoCadastral) {
		this.situacaoCadastralNaoDeveSerNula(situacaoCadastral);
		this.situacaoCadastral = situacaoCadastral;
	}

	public SituacaoEspecial getSituacaoEspecial() {
		return situacaoEspecial;
	}

	public void setSituacaoEspecial(SituacaoEspecial situacaoEspecial) {
		this.situacaoEspecialNaoDeveSerNula(situacaoEspecial);
		this.situacaoEspecial = situacaoEspecial;
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
		validarIntervalo(definirData(year, month, date));
		this.dataAlteracao = definirData(year, month, date);
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(int year, int month, int date) {
		validarIntervalo(definirData(year, month, date));
		this.dataCadastro = definirData(year, month, date);
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	private void situacaoEspecialNaoDeveSerNula(SituacaoEspecial situacaoEspecial) {
		if (situacaoEspecial == null) {
			throw new IllegalArgumentException("A Situação Especial Da Empresa Não deve ser nula");
		}
	}

	private void usuarioNaoDeveSerNulo(String usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Usuario Não Deve Ser Nulo");
		}
	}

	private void atividadeDaEmpresaNaoDeveSerNula(Atividade atividade) {
		if (atividade == null) {
			throw new IllegalArgumentException("A Atividade da Empresa Não deve ser nula");
		}
	}

	private void enderecoNaoDeveSerNulo(Endereco endereco) {
		if (endereco == null) {
			throw new IllegalArgumentException("O Endereço Da Empresa Não deve ser nulo");
		}
	}

	private void contatoNaoDeveSerNulo(Contato contato) {
		if (contato == null) {
			throw new IllegalArgumentException("O Contato Da Empresa Não deve ser nula");
		}
	}

	private void situacaoCadastralNaoDeveSerNula(SituacaoCadastral situacaoCadastral) {
		if (situacaoCadastral == null) {
			throw new IllegalArgumentException("A Situação Cadastral Não deve ser nula");
		}
	}

	private void cnpjNaoDeveConterEspacosEmBranco(String cnpj) {
		if (cnpj.substring(INIT_LENGTH, CNPJ_LENGTH).matches(" ")) {
			throw new IllegalArgumentException(
					"O Codigo de Atividade Secundaria da Empresa não pode conter espaços em branco");
		}
	}

	private void enteFederativoNaoDeveUltrapassarLimiteDeCaracteres(String enteFederativo) {
		if (enteFederativo.length() > STRING_MAX_LENGTH) {
			throw new IllegalArgumentException("O Ente Federativo não deve ultrapassar 255 caracteres");
		}
	}

	private void porteNaoDeveUltrapassarLimiteDeCaracteres(String porte) {
		if (porte.length() > MAX_LENGTH_PORTE) {
			throw new IllegalArgumentException("A Natureza Juridica não deve ultrapassar 255 caracteres");
		}
	}

	private void naturezaJuridicaNaoDeveUltrapassarLimiteDeCaracteres(String natJuridica) {
		if (natJuridica.length() > STRING_MAX_LENGTH) {
			throw new IllegalArgumentException("A Natureza Juridica não deve ultrapassar 255 caracteres");
		}
	}

	private void nomeFantasiaNaoDeveUltrapassarLimiteDeCaracteres(String nomeFantasia) {
		if (nomeFantasia.length() > LENGTH_MAX_NOMEFANTASIA) {
			throw new IllegalArgumentException("A Atividade da Empresa não deve ultrapassar 255 digitos");
		}
	}

	private void razaoSocialNaoDeveUltrapassarLimiteDeCaracteres(String razaoSocial) {
		if (razaoSocial.length() > STRING_MAX_LENGTH) {
			throw new IllegalArgumentException("A Razão Social não deve ultrapassar 255 caracteres");
		}
	}

	private void nomeFantasiaNaoDeveSerNulo(String nomeFantasia) {
		if (nomeFantasia == null) {
			throw new IllegalArgumentException("O Nome Fantasia da empresa não pode ser nulo");
		}
	}

	private void razaoSocialNaoDeveSerNula(String razaoSocial) {
		if (razaoSocial == null) {
			throw new IllegalArgumentException("A razão social da empresa não pode ser nula");
		}
	}

	private void porteDaEmpresaNaoDeveSerNulo(String porte) {
		if (porte == null) {
			throw new IllegalArgumentException("O Porte Da Empresa não deve ser nulo");
		}
	}

	private void naturezaJuridicaNaoDeveSerNula(String natJuridica) {
		if (natJuridica == null) {
			throw new IllegalArgumentException("A Natureza Juridica da empresa não pode ser nula");
		}
	}

	private void codigoDeNaturezaJuridicaNaoDeveConterLetras(String codNatJuridica) {
		if (codNatJuridica.substring(INIT_LENGTH, CODIGO_LENGTH).matches("[A-Z|a-z]*")) {
			throw new IllegalArgumentException("O Codigo de Natureza Juridica da Empresa não pode conter letras");
		}
	}

	private void codigoDeNaturezaJuridicaNaoDeveSerNulo(String codNatJuridica) {
		if (codNatJuridica == null) {
			throw new IllegalArgumentException("O Codigo de Natureza Juridica não pode ser nulo");
		}
	}

	private void codigoDeNaturezaJuridicaDeveConterApenas4Digitos(String codNatJuridica) {
		if (codNatJuridica.length() != NATJURIDICA_LENGTH) {
			throw new IllegalArgumentException("O Codigo de Netureza Juridica da empresa deve conter 4 digitos");
		}
	}

	private void validarCnpj(String cnpj) {
		if (!this.calcularCnpj(cnpj)) {
			throw new IllegalStateException("O CNPJ digitado não é valido");
		}
	}

	private boolean calcularCnpj(String cnpj) {
		char dig13 = validarDigito(cnpj, 11);
		char dig14 = validarDigito(cnpj, 12);
		return validar2UltimosDigitos(cnpj, dig13, dig14);
	}

	private char validarDigito(String cnpj, int quantidade) {
		char dig13;
		int sm;
		int r;
		sm = 0;
		sm = repeticao(cnpj, sm, quantidade);
		r = sm % 11;
		dig13 = validar11PrimeirosDigitos(r);
		return dig13;
	}

	private boolean validar2UltimosDigitos(String cnpj, char dig13, char dig14) {
		if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) {
			return (true);
		} else {
			return (false);
		}
	}

	private char validar11PrimeirosDigitos(int r) {
		char dig13;
		if ((r == 0) || (r == 1)) {
			dig13 = '0';
		} else {
			dig13 = (char) ((11 - r) + 48);
		}
		return dig13;
	}

	private int repeticao(String cnpj, int sm, int valor) {
		int i;
		int num;
		int peso = 2;
		for (i = valor; i >= 0; i--) {
			num = (int) (cnpj.charAt(i) - 48);
			sm = sm + (num * peso);
			peso = peso + 1;
			if (peso == 10)
				peso = 2;
		}
		return sm;
	}

	private void cnpjNaoPodeSerNulo(String cnpj) {
		if (cnpj == null) {
			throw new IllegalArgumentException("O CNPJ da Empresa não pode ser nulo");
		}
	}

	private void cnpjDeveConter14Digitos(String cnpj) {
		if (cnpj.length() != 14) {
			throw new IllegalArgumentException("O CNPJ da Empresa não pode ser menor que 11 caracteres");
		}
	}

	private void cnpjNãoPodeTerLetras(String cnpj) {
		if (cnpj.substring(0, 13).matches("[A-Z|a-z]*")) {
			throw new IllegalArgumentException("O CNPJ da Empresa não pode conter letras");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Empresa other = (Empresa) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empresa [cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia
				+ ", codNatJuridica=" + codNatJuridica + ", natJuridica=" + natJuridica + ", porte=" + porte
				+ ", dataAbertura=" + dataAbertura + ", enteFederativo=" + enteFederativo + "]";
	}

}