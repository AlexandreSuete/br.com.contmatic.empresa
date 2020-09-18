package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MunicipioTest {
	
Municipio municipio = null;
	
	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Municipio");
	}

	@BeforeEach
	public void initEach() {
		municipio = new Municipio();
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Municipio");
	}
	
	@Test
	@Order(1)
	public void municipio_da_empresa_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			municipio.setMunicipio(null);
		});
	}
	
	@Test
	@Order(2)
	public void testar_uf() {
		this.uf_da_empresa_nao_deve_ser_nulo();
		this.uf_da_empresa_deve_conter_2_letras();
		this.uf_da_empresa_nao_deve_conter_numeros();
	}
	
	private void uf_da_empresa_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			municipio.setUf(null);
		});
	}

	private void uf_da_empresa_deve_conter_2_letras() {
		assertThrows(IllegalArgumentException.class, () -> {
			municipio.setUf("abc");
		});
	}

	private void uf_da_empresa_nao_deve_conter_numeros() {
		assertThrows(IllegalArgumentException.class, () -> {
			municipio.setUf("12");
		});
	}

}
