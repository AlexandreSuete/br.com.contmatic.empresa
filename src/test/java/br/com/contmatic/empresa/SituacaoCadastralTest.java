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
	
	SituacaoCadastral sitCadastral2 = null;
	
	SituacaoCadastral sitCadastral3 = null;
	
	SituacaoCadastral sitCadastral4 = null;
	
	SituacaoCadastral sitCadastral5 = null;

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
		sitCadastral2 = new SituacaoCadastral("", "ATIVA", new Date());
		sitCadastral3 = new SituacaoCadastral("Qualquer coisa", "Inativa", new Date());
		sitCadastral4 = new SituacaoCadastral(null);
		sitCadastral5 = new SituacaoCadastral(null);
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
		this.deve_aceitar_data_valida();
		this.deve_retornar_toString_corretamente();
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
	
	@Test
	@Order(4)
	void nao_deve_ultrapassar_limite_caracteres( ) {
		this.string_motivo();
		this.string_status();
	}
	
	@Test
	void deve_aceitar_hashcode_valido() {
		assertEquals(sitCadastral.hashCode(), sitCadastral2.hashCode());
	}
	
	@Test
	void nao_deve_aceitar_hashcode_diferente() {
		assertEquals(false, sitCadastral3.hashCode() == sitCadastral.hashCode());
	}
	
	@Test
	void teste_equals_hashcode() {
		assertEquals(true,sitCadastral.equals(sitCadastral));
		assertEquals(false,sitCadastral.equals(null));
		assertEquals(false,sitCadastral.equals(1));
		assertEquals(false,sitCadastral.equals(sitCadastral3));
		assertEquals(false,sitCadastral4.equals(sitCadastral));
		assertEquals(true,sitCadastral.equals(sitCadastral2));
		assertEquals(true,sitCadastral4.equals(sitCadastral5));
		assertEquals(true,sitCadastral.hashCode() == sitCadastral2.hashCode());
		assertEquals(false,sitCadastral4.hashCode() == sitCadastral2.hashCode());
	}
	
	private void string_motivo() {
		assertThrows(IllegalArgumentException.class, () -> {
			sitCadastral.setMotivo(
					"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit. Morbi scelerisque luctus velit. Etiam dui sem, fermentum vitae, sagittis id, malesuada in, quam. Proin mattis lacinia justo. Vestibulum facilisis auctor urna. Aliquam in lorem sit amet leo accumsan lacinia. Integer rutrum, orci vestibulum ullamcorper ultricies, lacus quam ultricies odio, vitae placerat pede sem sit amet enim. Phasellus et lorem id felis nonummy placerat. Fusce dui leo, imperdiet in, aliquam sit amet, feugiat eu, orci. Aenean vel massa quis mauris vehicula lacinia. Quisque tincidunt scelerisque libero. Maecenas libero. Etiam dictum tincidunt diam. Donec ipsum massa, ullamcorper in, auctor et, scelerisque sed, est. Suspendisse nisl. Sed convallis magna eu sem. Cras pede libero, dapibus nec, pretium sit amet, tempor quis, urna. Aenean placerat. In vulputate urna eu arcu. Aliquam erat volutpat. Suspendisse potenti. Morbi mattis felis at nunc. Duis viverra diam non justo. In nisl. Nullam sit amet magna in magna gravida vehicula. Mauris tincidunt sem sed arcu. Nunc posuere. Nullam lectus justo, vulputate eget, mollis sed, tempor sed, magna. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam neque. Curabitur ligula sapien, pulvinar a, vestibulum quis, facilisis vel, sapien. Nullam eget nisl. Donec vitae arcu.\r\n"
							+ "\r\n"
							+ " Praesent in mauris eu tortor porttitor accumsan. Mauris suscipit, ligula sit amet pharetra semper, nibh ante cursus purus, vel sagittis velit mauris vel metus. Aenean fermentum risus id tortor. Integer imperdiet lectus quis justo. Integer tempor. Vivamus ac urna vel leo pretium faucibus. Mauris elementum mauris vitae tortor. In dapibus augue non sapien.");
		});
	}
	
	private void string_status() {
		assertThrows(IllegalArgumentException.class, () -> {
			sitCadastral.setStatus(
					"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit. Morbi scelerisque luctus velit. Etiam dui sem, fermentum vitae, sagittis id, malesuada in, quam. Proin mattis lacinia justo. Vestibulum facilisis auctor urna. Aliquam in lorem sit amet leo accumsan lacinia. Integer rutrum, orci vestibulum ullamcorper ultricies, lacus quam ultricies odio, vitae placerat pede sem sit amet enim. Phasellus et lorem id felis nonummy placerat. Fusce dui leo, imperdiet in, aliquam sit amet, feugiat eu, orci. Aenean vel massa quis mauris vehicula lacinia. Quisque tincidunt scelerisque libero. Maecenas libero. Etiam dictum tincidunt diam. Donec ipsum massa, ullamcorper in, auctor et, scelerisque sed, est. Suspendisse nisl. Sed convallis magna eu sem. Cras pede libero, dapibus nec, pretium sit amet, tempor quis, urna. Aenean placerat. In vulputate urna eu arcu. Aliquam erat volutpat. Suspendisse potenti. Morbi mattis felis at nunc. Duis viverra diam non justo. In nisl. Nullam sit amet magna in magna gravida vehicula. Mauris tincidunt sem sed arcu. Nunc posuere. Nullam lectus justo, vulputate eget, mollis sed, tempor sed, magna. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam neque. Curabitur ligula sapien, pulvinar a, vestibulum quis, facilisis vel, sapien. Nullam eget nisl. Donec vitae arcu.\r\n"
							+ "\r\n"
							+ " Praesent in mauris eu tortor porttitor accumsan. Mauris suscipit, ligula sit amet pharetra semper, nibh ante cursus purus, vel sagittis velit mauris vel metus. Aenean fermentum risus id tortor. Integer imperdiet lectus quis justo. Integer tempor. Vivamus ac urna vel leo pretium faucibus. Mauris elementum mauris vitae tortor. In dapibus augue non sapien.");
		});
	}

	private void deve_aceitar_usuario_valido() {
		assertEquals("Alexandre", sitCadastral.getUsuario());
	}

	private void deve_aceitar_data_de_alteracao_valida() {
		assertEquals(new Date(), sitCadastral.getDataAlteracao());
	}
	
	private void deve_retornar_toString_corretamente() {
		assertEquals("SituacaoCadastral [motivo=, status=ATIVA, data="+ sitCadastral.getDataSituacaoCadastral() + "]", sitCadastral.toString());
	}

	private void deve_aceitar_data_de_cadastro_valida() {
		assertEquals(new Date(), sitCadastral.getDataCadastro());
	}
	
	private void deve_aceitar_data_valida() {
		assertEquals(new Date(), sitCadastral.getDataSituacaoCadastral());
	}

	private void deve_aceitar_motivo_valido() {
		assertEquals("", sitCadastral.getMotivo());
	}

	private void deve_aceitar_status_valido() {
		assertEquals("ATIVA", sitCadastral.getStatus());
	}

}
