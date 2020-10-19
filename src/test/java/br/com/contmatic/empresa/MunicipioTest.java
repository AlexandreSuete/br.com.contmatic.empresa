package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MunicipioTest {

	Municipio municipio = null;

	@BeforeAll
	static void init() {
		System.out.println("Iniciando os Testes de Municipio");
	}

	@BeforeEach
	void initEach() {
		municipio = new Municipio("SAO JOSE DOS CAMPOS", "SP");
		municipio.setUsuario("Alexandre");
	}

	@AfterAll
	static void cleanUp() {
		System.out.println("Finalizando os testes de Municipio");
	}

	@Test
	@Order(1)
	void testar_dados_validos() {
		this.deve_aceitar_data_de_alteracao_valida();
		this.deve_aceitar_data_de_cadastro_valida();
		this.deve_aceitar_municipio_valido();
		this.deve_aceitar_uf_valido();
		this.deve_aceitar_usuario_valido();
	}

	@Test
	@Order(2)
	void municipio_da_empresa_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			municipio.setMunicipio(null);
		});
	}

	@Test
	@Order(3)
	void testar_uf() {
		this.uf_da_empresa_nao_deve_ser_nulo();
		this.uf_da_empresa_deve_conter_2_letras();
		this.uf_da_empresa_nao_deve_conter_numeros();
	}

	@Test
	@Order(4)
	void nao_deve_aceitar_usuario_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			municipio.setUsuario(null);
		});
	}

	private void deve_aceitar_municipio_valido() {
		assertEquals("SAO JOSE DOS CAMPOS", municipio.getMunicipio());
	}

	private void deve_aceitar_uf_valido() {
		assertEquals("SP", municipio.getUf());
	}

	private void deve_aceitar_usuario_valido() {
		assertEquals("Alexandre", municipio.getUsuario());
	}

	private void deve_aceitar_data_de_alteracao_valida() {
		municipio.setDataAlteracao(new Date());
		assertEquals(new Date(), municipio.getDataAlteracao());
	}

	private void deve_aceitar_data_de_cadastro_valida() {
		municipio.setDataCadastro(new Date());
		assertEquals(new Date(), municipio.getDataCadastro());
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
