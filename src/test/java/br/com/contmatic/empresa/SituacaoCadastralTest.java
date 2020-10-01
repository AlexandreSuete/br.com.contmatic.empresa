package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SituacaoCadastralTest {

	SituacaoCadastral sitCadastral = null;

	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Situação Cadastral");
	}

	@BeforeEach
	public void initEach() {
		sitCadastral = new SituacaoCadastral("", "ATIVA", 2004, 05, 26);
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Situação Cadastral");
	}

	@Test
	@Order(0)
	public void testar_dados_validos() {
		this.deve_aceitar_motivo_valido();
		this.deve_aceitar_status_valido();
	}

	@Test
	@Order(1)
	public void status_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			sitCadastral.setStatus(null);
		});
	}

	@Test
	@Order(2)
	public void motivo_situacao_cadastral_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			sitCadastral.setMotivo(null);
		});
	}

	private void deve_aceitar_motivo_valido() {
		assertEquals("", sitCadastral.getMotivo());
	}

	private void deve_aceitar_status_valido() {
		assertEquals("ATIVA", sitCadastral.getStatus());
	}

}
