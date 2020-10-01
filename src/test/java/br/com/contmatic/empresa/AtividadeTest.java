package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AtividadeTest {
	Atividade atividade = null;

	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Atividade");
	}

	@BeforeEach
	public void initEach() {
		atividade = new Atividade("6203100",
				"Desenvolvimento e Licenciamento de programas de computador não-customizáveis");
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Atividade");
	}

	@Test
	public void testar_dados_validos() {
		this.deve_aceitar_atividade_secudaria_valida();
		this.deve_aceitar_codigo_valido();
		this.deve_aceitar_descricao_valida();
	}

	@Test
	public void testar_codigo_de_atividade() {
		this.codigo_de_atividade_nao_deve_ser_nulo();
		this.codigo_de_atividade_nao_deve_passar_de_7_digitos();
		this.nao_deve_aceitar_letras_no_codigo_de_atividade();
	}

	private void codigo_de_atividade_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			atividade.setCodigo("null");
		});
	}

	private void codigo_de_atividade_nao_deve_passar_de_7_digitos() {
		assertThrows(IllegalArgumentException.class, () -> {
			atividade.setCodigo("123456789");
		});
	}

	private void nao_deve_aceitar_letras_no_codigo_de_atividade() {
		assertThrows(IllegalArgumentException.class, () -> {
			atividade.setCodigo("ADGHUYT");
		});
	}

	private void deve_aceitar_atividade_secudaria_valida() {
		atividade.setSecundario("8599699", "Outras atividades de ensino não especificadas anteriormente");
		assertEquals(
				"Atividade [codigo=8599699, descricao=Outras atividades de ensino não especificadas anteriormente]",
				atividade.getSecundario());
	}

	private void deve_aceitar_codigo_valido() {
		assertEquals("6203100", atividade.getCodAtividade());
	}

	private void deve_aceitar_descricao_valida() {
		assertEquals("Desenvolvimento e Licenciamento de programas de computador não-customizáveis",
				atividade.getAtividade());
	}
}
