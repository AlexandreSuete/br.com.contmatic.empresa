package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 class ContatoTest {

	Contato contato = null;

	Telefone telefone = new Telefone(55, 11, "29426700");

	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Contato");
	}

	@BeforeEach
	public void initEach() {
		contato = new Contato("FINANCEIRO@CONTMATIC.COM.BR", telefone);
		contato.setUsuario("Alexandre");
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Contato");
	}

	@Test
	 void testar_email() {
		this.email_da_empresa_nao_deve_ser_nulo();
		this.email_da_empresa_deve_ser_valido();
	}
	
	@Test
	void nao_deve_aceitar_usuario_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			contato.setUsuario(null);
		});
	}

	@Test
	void deve_aceitar_usuario_valido() {
		assertEquals("Alexandre", contato.getUsuario());
	}

	@Test
	void deve_aceitar_data_de_alteracao_valida() {
		contato.setDataAlteracao(new Date());
		assertEquals(new Date(), contato.getDataAlteracao());
	}

	@Test
	void deve_aceitar_data_de_cadastro_valida() {
		contato.setDataCadastro(new Date());
		assertEquals(new Date(), contato.getDataCadastro());
	}

	private void email_da_empresa_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			contato.setEmail(null);
		});
	}

	private void email_da_empresa_deve_ser_valido() {
		assertThrows(IllegalStateException.class, () -> {
			contato.setEmail("alexandre");
		});
	}
}
