package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnderecoTest {

	Endereco endereco = null;

	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Endereço");
	}

	@BeforeEach
	public void initEach() {
		endereco = new Endereco();
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Endereço");
	}

	@Test
	public void testar_cep() {
		this.cep_da_empresa_nao_deve_ser_nulo();
		this.cep_da_empresa_deve_conter_8_letras();
	}

	@Test
	public void testar_numero_do_logradouro() {
		this.numero_do_logradouro_nao_deve_passar_de_10000();
		this.numero_do_logradouro_nao_deve_ser_menor_que_1();
	}

	@Test
	public void logradouro_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			endereco.setLogradouro(null);
		});
	}

	@Test
	public void bairro_da_empresa_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			endereco.setBairro(null);
		});
	}

	private void cep_da_empresa_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			endereco.setCep(null);
		});
	}

	private void cep_da_empresa_deve_conter_8_letras() {
		assertThrows(IllegalArgumentException.class, () -> {
			endereco.setCep("abc");
		});
	}

	private void numero_do_logradouro_nao_deve_ser_menor_que_1() {
		assertThrows(IllegalArgumentException.class, () -> {
			endereco.setNumLogradouro(0);
			;
		});
	}

	private void numero_do_logradouro_nao_deve_passar_de_10000() {
		assertThrows(IllegalArgumentException.class, () -> {
			endereco.setNumLogradouro(10001);
			;
		});
	}

}
