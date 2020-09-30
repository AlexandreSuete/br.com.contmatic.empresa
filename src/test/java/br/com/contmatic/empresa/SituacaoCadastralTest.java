package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;

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

	String dataSitCadastral = "26/06/2004";

	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Situação Cadastral");
	}

	@BeforeEach
	public void initEach() throws ParseException {
		sitCadastral = new SituacaoCadastral("", "ATIVA", dataSitCadastral);
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Situação Cadastral");
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

}
