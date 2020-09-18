package br.com.contmatic.empresa;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


public class EmpresaTest {
	
	Empresa empresa = null;

	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Empresa");
	}

	@BeforeEach
	public void initEach() {
		empresa = new Empresa();
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Empresa");
	}

	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	public void testar_cnpj() {
		this.nao_deve_aceitar_cnpj_nulo();
		this.nao_deve_aceitar_cnpj_maior_que_14_caracteres();
		this.nao_deve_aceitar_cnpj_menor_que_14_caracteres();
		this.nao_deve_aceitar_letras_no_cnpj();
		this.cnpj_nao_deve_conter_espacos();
		this.cnpj_deve_ser_valido();
	}

	@Test
	public void testar_codigo_de_natureza_juridica() {
		this.natureza_juridica_nao_deve_ser_nula();
		this.codigo_de_natureza_juridica_nao_deve_passar_de_4_digitos();
		this.nao_deve_aceitar_letras_no_codigo_de_natureza_juridica();
	}

	@Test
	public void nao_deve_aceitar_nome_fantasia_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setNomeFantasia(null);
		});
	}

	@Test
	public void porte_da_empresa_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setPorte(null);
		});
	}

	@Test
	public void nao_deve_aceitar_razao_social_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setRazaoSocial(null);
		});
	}
	
	@Disabled
	@Test
	public void banco_de_dados_deve_ser_acessado_com_sucesso() {
		
	}
	
	private void cnpj_nao_deve_conter_espacos() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setCnpj("          ");
		});
	}

	private void nao_deve_aceitar_cnpj_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setCnpj(null);
		});
	}

	private void nao_deve_aceitar_cnpj_maior_que_14_caracteres() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setCnpj("123456789012345");
		});
	}

	private void nao_deve_aceitar_cnpj_menor_que_14_caracteres() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setCnpj("1234567890");
		});
	}

	private void nao_deve_aceitar_letras_no_cnpj() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setCnpj("ASDFGHJKLOIUYT");
		});
	}

	private void cnpj_deve_ser_valido() {
		assertThrows(IllegalStateException.class, () -> {
			empresa.setCnpj("12345678901234");
		});
	}

	private void codigo_de_natureza_juridica_nao_deve_passar_de_4_digitos() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setCodNatJuridica("123456");
		});
	}

	private void nao_deve_aceitar_letras_no_codigo_de_natureza_juridica() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setCodNatJuridica("ASDF");
		});
	}

	private void natureza_juridica_nao_deve_ser_nula() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setNatJuridica(null);
		});
	}
}