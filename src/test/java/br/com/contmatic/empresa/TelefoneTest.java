package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 class TelefoneTest {

	Telefone telefone = null;

	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Telefone");
	}

	@BeforeEach
	public void initEach() {
		telefone = new Telefone(55, 11, "29426700");
		telefone.setUsuario("Alexandre");
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Telefone");
	}

	@Test
	void testar_dados_validos() {
		this.deve_aceitar_data_de_cadastro_valida();
		this.deve_aceitar_data_de_alteracao_valida();
		this.deve_aceitar_ddd_valido();
		this.deve_aceitar_ddi_valido();
		this.deve_aceitar_usuario_valido();
		this.deve_aceitar_telefone_valido();
	}

	@Test
	void testar_telefone() {
		this.telefone_nao_deve_conter_letras();
		this.telefone_da_empresa_nao_deve_ser_nulo();
		this.telefone_da_empresa_deve_conter_9_digitos();
	}
	
	@Test
	void nao_deve_aceitar_usuario_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			telefone.setUsuario(null);
		});
	}

	@Test
	void deve_aceitar_usuario_valido() {
		assertEquals("Alexandre", telefone.getUsuario());
	}
	
	@Test
	void nao_deve_aceitar_ddi_invalido_abaixo_de_um() {
		assertThrows(IllegalArgumentException.class, () -> {
			telefone.setDdi(0);
		});
	}
	
	@Test
	void nao_deve_aceitar_ddi_invalido() {
		assertThrows(IllegalArgumentException.class, () -> {
			telefone.setDdi(10000);
		});
	}
	
	@Test
	void nao_deve_aceitar_ddd_invalido() {
		assertThrows(IllegalArgumentException.class, () -> {
			telefone.setDdd(9);
		});
	}
	
	@Test
	void nao_deve_aceitar_ddd_invalido_superior_a_99() {
		assertThrows(IllegalArgumentException.class, () -> {
			telefone.setDdd(100);
		});
	}

	private void deve_aceitar_data_de_alteracao_valida() {
		telefone.setDataAlteracao(new Date());
		assertEquals(new Date(), telefone.getDataAlteracao());
	}

	private void deve_aceitar_data_de_cadastro_valida() {
		telefone.setDataCadastro(new Date());
		assertEquals(new Date(), telefone.getDataCadastro());
	}

	private void telefone_da_empresa_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			telefone.setTelefone(null);
		});
	}

	private void telefone_da_empresa_deve_conter_9_digitos() {
		assertThrows(IllegalArgumentException.class, () -> {
			telefone.setTelefone("0123456");
		});
	}

	private void telefone_nao_deve_conter_letras() {
		assertThrows(IllegalArgumentException.class, () -> {
			telefone.setTelefone("asdefefe");
		});
	}

	private void deve_aceitar_ddi_valido() {
		assertEquals(55, telefone.getDdi());
	}

	private void deve_aceitar_ddd_valido() {
		assertEquals(11, telefone.getDdd());
	}

	private void deve_aceitar_telefone_valido() {
		assertEquals("29426700", telefone.getTelefone());
	}

}
