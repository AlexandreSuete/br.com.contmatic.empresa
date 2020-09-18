package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SituacaoEspecialTest {
	
	SituacaoEspecial sitEspecial = null;
	
	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Situação Especial");
	}

	@BeforeEach
	public void initEach() {
		sitEspecial = new SituacaoEspecial();
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Situação Especial");
	}
	
	@Test
	@Order(1)
	public void situacao_especial_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			sitEspecial.setSitEspecial(null);
		});
	}
	
	@Test
	@Order(2)
	public void data_situacao_cadastral_deve_ser_valida() {
		assertThrows(IllegalStateException.class, () -> {
			sitEspecial.setDataSitEspecial(32,23,2090);
		});
	}
}