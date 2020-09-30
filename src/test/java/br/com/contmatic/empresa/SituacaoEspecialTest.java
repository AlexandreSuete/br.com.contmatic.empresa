package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SituacaoEspecialTest {
	
	SituacaoEspecial sitEspecial = null;
	
	String data = "23/09/2019";
	
	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Situação Especial");
	}

	@BeforeEach
	public void initEach() throws ParseException {
		sitEspecial = new SituacaoEspecial("INATIVA",data);
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Situação Especial");
	}
	
	@Test
	@Order(1)
	public void situacao_especial_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			sitEspecial.setStatus(null);
		});
	}
	
	@Test
	@Order(2)
	public void data_situacao_especial_deve_ser_valida() {
		assertThrows(IllegalStateException.class, () -> {
			sitEspecial.setData("32/08/2023");
		});
	}
}