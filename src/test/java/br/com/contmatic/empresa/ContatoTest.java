package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContatoTest {

	Contato contato = null;

	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Contato");
	}

	@BeforeEach
	public void initEach() {
		contato = new Contato();
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Contato");
	}

	@Test
	public void testar_email() {
		this.email_da_empresa_nao_deve_ser_nulo();
		this.email_da_empresa_deve_ser_valido();
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
