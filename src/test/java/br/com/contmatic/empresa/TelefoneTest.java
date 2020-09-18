package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TelefoneTest {
	
	Telefone telefone = null;

	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Telefone");
	}

	@BeforeEach
	public void initEach() {
		telefone = new Telefone();
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Telefone");
	}
	
	@Test
	public void testar_telefone() {
		this.telefone_da_empresa_nao_deve_ser_nulo();
		this.telefone_da_empresa_deve_conter_9_ou_8_numeros();
		this.telefone_nao_deve_conter_letras();
	}
	
	private void telefone_da_empresa_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			telefone.setTelefone(null);
		});
	}

	private void telefone_da_empresa_deve_conter_9_ou_8_numeros() {
		assertThrows(IllegalArgumentException.class, () -> {
			telefone.setTelefone("0123456");
		});
	}

	private void telefone_nao_deve_conter_letras() {
		assertThrows(IllegalArgumentException.class, () -> {
			telefone.setTelefone("asdefefef");
		});
	}

}
