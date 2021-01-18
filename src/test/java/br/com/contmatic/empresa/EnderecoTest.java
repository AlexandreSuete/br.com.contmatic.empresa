package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnderecoTest {

	Endereco endereco = null;
	
	Endereco endereco2 = null;

	Endereco endereco3 = null;
	
	Endereco endereco4 = null;
	
	Endereco endereco5 = null;
	
	Municipio municipio = new Municipio("SAO JOSE DOS CAMPOS", "SP");
	
	Municipio municipio2 = new Municipio("Rio de Janeiro", "RJ");

	@BeforeAll
	static void init() {
		System.out.println("Iniciando os Testes de Endereço");
	}

	@BeforeEach
	void initEach() {
		endereco = new Endereco("R MAJOR VAZ", municipio, "VILA ADYANA", "12243670");
		endereco.setUsuario("Alexandre");
		endereco2 = new Endereco("R MAJOR VAZ", municipio, "VILA ADYANA", "12243670");
		endereco3 = new Endereco("Rua Padre Raposo", municipio2, "MOOCA", "03118000");
		endereco4 = new Endereco(null);
		endereco5 = new Endereco(null);
	}

	@AfterAll
	static void cleanUp() {
		System.out.println("Finalizando os testes de Endereço");
	}

	@Test
	void testar_dados_validos() {
		this.deve_aceitar_data_de_alteracao_valida();
		this.deve_aceitar_data_de_cadastro_valida();
		this.deve_aceitar_logradouro_valido();
		this.deve_aceitar_num_logradouro_valido();
		this.deve_aceitar_complemento_valido();
		this.deve_aceitar_bairro_valido();
		this.deve_aceitar_cep_valido();
		this.deve_aceitar_usuario_valido();
		this.deve_aceitar_municipio_valido();
	}

	@Test
	void toString_deve_retornar_corretamente() {
		assertEquals(
				"Endereco [logradouro=R MAJOR VAZ, numLogradouro=0, complemento=null, municipio=Municipio [municipio=SAO JOSE DOS CAMPOS, uf=SP], bairro=VILA ADYANA, cep=12243670]",
				endereco.toString());
	}

	@Test
	void string_logradouro_nao_deve_ultrapassar_limite_de_caracteres() {
		assertThrows(IllegalArgumentException.class, () -> {
			endereco.setLogradouro(
					"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit. Morbi scelerisque luctus velit. Etiam dui sem, fermentum vitae, sagittis id, malesuada in, quam. Proin mattis lacinia justo. Vestibulum facilisis auctor urna. Aliquam in lorem sit amet leo accumsan lacinia. Integer rutrum, orci vestibulum ullamcorper ultricies, lacus quam ultricies odio, vitae placerat pede sem sit amet enim. Phasellus et lorem id felis nonummy placerat. Fusce dui leo, imperdiet in, aliquam sit amet, feugiat eu, orci. Aenean vel massa quis mauris vehicula lacinia. Quisque tincidunt scelerisque libero. Maecenas libero. Etiam dictum tincidunt diam. Donec ipsum massa, ullamcorper in, auctor et, scelerisque sed, est. Suspendisse nisl. Sed convallis magna eu sem. Cras pede libero, dapibus nec, pretium sit amet, tempor quis, urna. Aenean placerat. In vulputate urna eu arcu. Aliquam erat volutpat. Suspendisse potenti. Morbi mattis felis at nunc. Duis viverra diam non justo. In nisl. Nullam sit amet magna in magna gravida vehicula. Mauris tincidunt sem sed arcu. Nunc posuere. Nullam lectus justo, vulputate eget, mollis sed, tempor sed, magna. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam neque. Curabitur ligula sapien, pulvinar a, vestibulum quis, facilisis vel, sapien. Nullam eget nisl. Donec vitae arcu.\r\n"
							+ "\r\n"
							+ " Praesent in mauris eu tortor porttitor accumsan. Mauris suscipit, ligula sit amet pharetra semper, nibh ante cursus purus, vel sagittis velit mauris vel metus. Aenean fermentum risus id tortor. Integer imperdiet lectus quis justo. Integer tempor. Vivamus ac urna vel leo pretium faucibus. Mauris elementum mauris vitae tortor. In dapibus augue non sapien.");
		});
	}

	@Test
	void testar_cep() {
		this.cep_da_empresa_nao_deve_ser_nulo();
		this.cep_da_empresa_deve_conter_8_letras();
	}

	@Test
	void testar_numero_do_logradouro() {
		this.numero_do_logradouro_nao_deve_passar_de_10000();
		this.numero_do_logradouro_nao_deve_ser_menor_que_1();
	}

	@Test
	void logradouro_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			endereco.setLogradouro(null);
		});
	}

	@Test
	void bairro_da_empresa_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			endereco.setBairro(null);
		});
	}

	@Test
	void nao_deve_aceitar_usuario_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			endereco.setUsuario(null);
		});
	}
	
	@Test
	void deve_aceitar_hashcode_valido() {
		assertEquals(endereco.hashCode(), endereco2.hashCode());
	}
	
	@Test
	void nao_deve_aceitar_hashcode_diferente() {
		assertEquals(false, endereco4.hashCode() == endereco.hashCode());
	}
	
	@Test
	void teste_equals() {
		assertEquals(true,endereco.equals(endereco));
		assertEquals(false,endereco.equals(null));
		assertEquals(false,endereco.equals(1));
		assertEquals(false,endereco.equals(endereco3));
		assertEquals(true,endereco.equals(endereco2));
		assertEquals(false,endereco4.equals(endereco));
		assertEquals(true,endereco4.equals(endereco5));
	}


	private void deve_aceitar_usuario_valido() {
		assertEquals("Alexandre", endereco.getUsuario());
	}

	private void deve_aceitar_data_de_alteracao_valida() {
		endereco.setDataAlteracao(new Date());
		assertEquals(new Date(), endereco.getDataAlteracao());
	}

	private void deve_aceitar_data_de_cadastro_valida() {
		endereco.setDataCadastro(new Date());
		assertEquals(new Date(), endereco.getDataCadastro());
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

	private void deve_aceitar_logradouro_valido() {
		assertEquals("R MAJOR VAZ", endereco.getLogradouro());
	}

	private void deve_aceitar_num_logradouro_valido() {
		endereco.setNumLogradouro(217);
		assertEquals(217, endereco.getNumLogradouro());
	}

	private void deve_aceitar_complemento_valido() {
		endereco.setComplemento("Perto de uma padaria");
		assertEquals("Perto de uma padaria", endereco.getComplemento());
	}

	private void deve_aceitar_bairro_valido() {
		assertEquals("VILA ADYANA", endereco.getBairro());
	}

	private void deve_aceitar_municipio_valido() {
		assertEquals(new Municipio("SAO JOSE DOS CAMPOS", "SP"), endereco.getMunicipio());
	}

	private void deve_aceitar_cep_valido() {
		assertEquals("12243670", endereco.getCep());
	}
}
