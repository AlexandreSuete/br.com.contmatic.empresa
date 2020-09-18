package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SituacaoCadastralTest {
	
	SituacaoCadastral sitCadastral = null;
	
	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Situação Cadastral");
	}

	@BeforeEach
	public void initEach() {
		sitCadastral = new SituacaoCadastral();
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Situação Cadastral");
	}
	
	@Test
	@Order(1)
	public void situacao_cadastral_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			sitCadastral.setStatus(null);
		});
	}
	
	@Test
	@Order(2)
	public void data_situacao_cadastral_deve_ser_valida() {
		assertThrows(IllegalStateException.class, () -> {
			sitCadastral.setData(32,23,2090);
		});
	}
	
	@Test
	@Order(3)
	public void motivo_situacao_cadastral_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			sitCadastral.setMotivo(null);
		});
	}

}
