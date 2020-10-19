package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SituacaoCadastralTest {

	SituacaoCadastral sitCadastral = null;

	@BeforeAll
	static void init() {
		System.out.println("Iniciando os Testes de Situação Cadastral");
	}

	@BeforeEach
	void initEach() {
		sitCadastral = new SituacaoCadastral("", "ATIVA", new Date());
		sitCadastral.setUsuario("Alexandre");
		sitCadastral.setDataAlteracao(new Date());
		sitCadastral.setDataCadastro(new Date());
	}

	@AfterAll
	static void cleanUp() {
		System.out.println("Finalizando os testes de Situação Cadastral");
	}

	@Test
	@Order(0)
	void testar_dados_validos() {
		this.deve_aceitar_motivo_valido();
		this.deve_aceitar_status_valido();
		this.deve_aceitar_usuario_valido();
		this.deve_aceitar_data_de_alteracao_valida();
		this.deve_aceitar_data_de_cadastro_valida();
	}

	@Test
	@Order(1)
	void status_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			sitCadastral.setStatus(null);
		});
	}

	@Test
	@Order(2)
	void motivo_situacao_cadastral_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			sitCadastral.setMotivo(null);
		});
	}
	
	@Test
	@Order(3)
	void nao_deve_aceitar_usuario_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			sitCadastral.setUsuario(null);
		});
	}

	private void deve_aceitar_usuario_valido() {
		assertEquals("Alexandre", sitCadastral.getUsuario());
	}

	private void deve_aceitar_data_de_alteracao_valida() {
		assertEquals(new Date(), sitCadastral.getDataAlteracao());
	}

	private void deve_aceitar_data_de_cadastro_valida() {
		assertEquals(new Date(), sitCadastral.getDataCadastro());
	}

	private void deve_aceitar_motivo_valido() {
		assertEquals("", sitCadastral.getMotivo());
	}

	private void deve_aceitar_status_valido() {
		assertEquals("ATIVA", sitCadastral.getStatus());
	}

}
