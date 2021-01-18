package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 class AtividadeTest {
	Atividade atividade = null;
	
	Atividade atividade2 = null;
	
	Atividade atividade3 = null;
	
	Atividade atividade4 = null;
	
	Atividade atividade5 = null;

	@BeforeAll
	static void init() {
		System.out.println("Iniciando os Testes de Atividade");
	}

	@BeforeEach
	void initEach() {
		atividade = new Atividade("6203100",
				"Desenvolvimento e Licenciamento de programas de computador não-customizáveis");
		atividade.setUsuario("Alexandre");
		atividade2 = new Atividade("6203100",
				"Desenvolvimento e Licenciamento de programas de computador não-customizáveis");
		atividade3 = new Atividade("6258964",
				"Teste de Descricao");
		atividade4 = new Atividade(null);
		atividade5 = new Atividade(null);
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Atividade");
	}

	@Test
	void testar_dados_validos() {
		this.deve_aceitar_data_de_cadastro_valida();
		this.deve_aceitar_data_de_alteracao_valida();
		this.deve_aceitar_usuario_valido();
		this.deve_aceitar_atividade_secudaria_valida();
		this.deve_aceitar_codigo_valido();
		this.deve_aceitar_descricao_valida();
	}

	@Test
	void testar_codigo_de_atividade() {
		this.codigo_de_atividade_nao_deve_ser_nulo();
		this.codigo_de_atividade_nao_deve_passar_de_7_digitos();
		this.nao_deve_aceitar_letras_no_codigo_de_atividade();
	}

	@Test
	void codigo_de_atividade_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			atividade.setCodigo(null);
		});
	}
	
	@Test
	void nao_deve_aceitar_usuario_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			atividade.setUsuario(null);
		});
	}
	
	@Test
	void nao_deve_aceitar_atividade_nula() {
		assertThrows(IllegalArgumentException.class, () -> {
			atividade.setDescricao(null);
		});
	}
	
	 @Test
	 void string_descricao() {
		assertThrows(IllegalArgumentException.class, () -> {
			atividade.setDescricao(
					"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit. Morbi scelerisque luctus velit. Etiam dui sem, fermentum vitae, sagittis id, malesuada in, quam. Proin mattis lacinia justo. Vestibulum facilisis auctor urna. Aliquam in lorem sit amet leo accumsan lacinia. Integer rutrum, orci vestibulum ullamcorper ultricies, lacus quam ultricies odio, vitae placerat pede sem sit amet enim. Phasellus et lorem id felis nonummy placerat. Fusce dui leo, imperdiet in, aliquam sit amet, feugiat eu, orci. Aenean vel massa quis mauris vehicula lacinia. Quisque tincidunt scelerisque libero. Maecenas libero. Etiam dictum tincidunt diam. Donec ipsum massa, ullamcorper in, auctor et, scelerisque sed, est. Suspendisse nisl. Sed convallis magna eu sem. Cras pede libero, dapibus nec, pretium sit amet, tempor quis, urna. Aenean placerat. In vulputate urna eu arcu. Aliquam erat volutpat. Suspendisse potenti. Morbi mattis felis at nunc. Duis viverra diam non justo. In nisl. Nullam sit amet magna in magna gravida vehicula. Mauris tincidunt sem sed arcu. Nunc posuere. Nullam lectus justo, vulputate eget, mollis sed, tempor sed, magna. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam neque. Curabitur ligula sapien, pulvinar a, vestibulum quis, facilisis vel, sapien. Nullam eget nisl. Donec vitae arcu.\r\n"
							+ "\r\n"
							+ " Praesent in mauris eu tortor porttitor accumsan. Mauris suscipit, ligula sit amet pharetra semper, nibh ante cursus purus, vel sagittis velit mauris vel metus. Aenean fermentum risus id tortor. Integer imperdiet lectus quis justo. Integer tempor. Vivamus ac urna vel leo pretium faucibus. Mauris elementum mauris vitae tortor. In dapibus augue non sapien.");
		});
	}
	
	@Test
	void deve_aceitar_hashcode_valido() {
		assertEquals(atividade.hashCode(), atividade2.hashCode());
	}
	
	@Test
	void nao_deve_aceitar_hashcode_diferente() {
		assertEquals(false, atividade3.hashCode() == atividade.hashCode());
	}

	@Test
	void teste_equals() {
		assertEquals(true,atividade.equals(atividade));
		assertEquals(false,atividade.equals(null));
		assertEquals(false,atividade.equals(1));
		assertEquals(false,atividade.equals(atividade3));
		assertEquals(false,atividade4.equals(atividade));
		assertEquals(true,atividade.equals(atividade2));
		assertEquals(true,atividade4.equals(atividade5));
		assertEquals(true,atividade.hashCode() == atividade2.hashCode());
		assertEquals(false,atividade4.hashCode() == atividade2.hashCode());
	}


	private void deve_aceitar_usuario_valido() {
		assertEquals("Alexandre", atividade.getUsuario());
	}

	private void deve_aceitar_data_de_alteracao_valida() {
		atividade.setDataAlteracao(new Date());
		assertEquals(new Date(), atividade.getDataAlteracao());
	}

	private void deve_aceitar_data_de_cadastro_valida() {
		atividade.setDataCadastro(new Date());
		assertEquals(new Date(), atividade.getDataCadastro());
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
