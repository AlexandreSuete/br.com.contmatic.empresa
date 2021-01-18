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
	
	Telefone telefone3 = new Telefone(55, 11, "29426701");
	
	Contato contato2 = null;
	
	Contato contato3 = null;
	
	Contato contato4 = null;
	
	Contato contato5 = null;

	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Contato");
	}

	@BeforeEach
	public void initEach() {
		contato = new Contato("FINANCEIRO@CONTMATIC.COM.BR", telefone);
		contato.setUsuario("Alexandre");
		contato2 = new Contato("FINANCEIRO@CONTMATIC.COM.BR", telefone);
		contato3 = new Contato("EMAILDIFERENTE@CONTMATIC.COM.BR", telefone3);
		contato4 = new Contato(null);
		contato5 = new Contato(null);
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
	
	@Test
	void deve_aceitar_email_valido() {
		assertEquals("FINANCEIRO@CONTMATIC.COM.BR", contato.getEmail());
	}
	
	@Test
	void deve_aceitar_telefone_valido() {
		assertEquals(telefone, contato.getTelefone());
	}
	
	@Test
	void não_deve_aceitar_telefone_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			contato.setTelefone(null);
		});
	}
	
	@Test
	void não_deve_aceitar_email_vazio() {
		assertThrows(IllegalStateException.class, () -> {
			contato.setEmail("");
		});
	}
	
	@Test
	void deve_aceitar_hashcode_valido() {
		assertEquals(contato.hashCode(), contato2.hashCode());
	}
	
	@Test
	void nao_deve_aceitar_hashcode_diferente() {
		assertEquals(false, contato3.hashCode() == contato.hashCode());
	}
	
	@Test
	void deve_retornar_toString_corretamente() {
		assertEquals("Contato [email=FINANCEIRO@CONTMATIC.COM.BR, telefone=Telefone [ddi=55, ddd=11, telefone=29426700]]", contato.toString());
	}
	
	@Test
	void teste_equals_hashcode() {
		assertEquals(true,contato.equals(contato));
		assertEquals(false,contato.equals(null));
		assertEquals(false,contato.equals(1));
		assertEquals(false,contato.equals(contato3));
		assertEquals(false,contato4.equals(contato));
		assertEquals(true,contato.equals(contato2));
		assertEquals(true,contato4.equals(contato5));
		assertEquals(true, contato.hashCode() == contato2.hashCode());
		assertEquals(false, contato4.hashCode() == contato2.hashCode());	
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
