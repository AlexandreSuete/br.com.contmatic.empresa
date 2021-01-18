package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class EmpresaTest {
	
	Calendar calendar = Calendar.getInstance();

	Empresa empresa = null;

	Empresa empresa2 = null;

	Empresa empresa3 = null;
	
	Empresa empresa4 = null;
	
	Empresa empresa5 = null;

	Telefone telefone = new Telefone(55, 11, "29426700");

	Contato contato = new Contato("FINANCEIRO@CONTMATIC.COM.BR", telefone);

	Municipio municipio = new Municipio("SAO JOSE DOS CAMPOS", "SP");

	Endereco endereco = new Endereco("R MAJOR VAZ", municipio, "VILA ADYANA", "12243670");

	Atividade atividade = new Atividade("6203100",
			"Desenvolvimento e licenciamento de programas de computador não-customizáveis");

	SituacaoCadastral situacaoCadastral = null;

	SituacaoEspecial situacaoEspecial = new SituacaoEspecial("INATIVA", new Date());

	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Empresa");
	}

	@BeforeEach
	public void initEach() {
		empresa = new Empresa("58119371000410", "SOFTMATIC SISTEMAS AUTOMATICOS DE INFORMATICA LTDA",
				"CONTMATIC PHOENIX", "2062", "Sociedade Empresária Limitada", "DEMAIS", new Date(), contato, endereco,
				atividade, situacaoCadastral = new SituacaoCadastral("", "ATIVA", new Date()));
		empresa.setSituacaoEspecial(situacaoEspecial);
		empresa.setUsuario("Alexandre");
		empresa.setIp("192.168.0.1");

		empresa2 = new Empresa("58119371000410", "SOFTMATIC SISTEMAS AUTOMATICOS DE INFORMATICA LTDA",
				"CONTMATIC PHOENIX", "2062", "Sociedade Empresária Limitada", "DEMAIS", new Date(), contato, endereco,
				atividade, situacaoCadastral = new SituacaoCadastral("", "ATIVA", new Date()));
		empresa2.setSituacaoEspecial(situacaoEspecial);
		empresa2.setUsuario("Alexandre");
		empresa2.setIp("192.168.0.1");
		empresa3 = new Empresa("61908973000118", "SOFTMATIC SISTEMAS AUTOMATICOS DE INFORMATICA LTDA",
				"CONTMATIC PHOENIX", "2062", "Sociedade Empresária Limitada", "DEMAIS", new Date(), contato, endereco,
				atividade, situacaoCadastral = new SituacaoCadastral("", "ATIVA", new Date()));
		empresa4 = new Empresa(null);
		empresa5 = new Empresa(null);
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Empresa");
	}

	@Test
	void testar_dados_validos() {
		this.deve_aceitar_data_de_alteracao_valida();
		this.deve_aceitar_data_de_cadastro_valida();
		this.deve_aceitar_empresa_valida();
		this.deve_aceitar_razao_social_valida();
		this.deve_aceitar_nome_fantasia_valido();
		this.deve_aceitar_codigo_de_nat_juridica_valido();
		this.deve_aceitar_nat_juridica_valida();
		this.deve_aceitar_porte_valido();
		this.deve_aceitar_ente_federativo_valido();
		this.deve_aceitar_data_valida();
		this.deve_aceitar_contato_valido();
		this.deve_aceitar_atividade_valida();
		this.deve_aceitar_endereço_valido();
		this.deve_aceitar_situacao_cadastral_valida();
		this.deve_aceitar_situacao_especial_valida();
		this.deve_aceitar_usuario_valido();
		this.deve_aceitar_ip_valido();
	}

	@Test
	@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
	void testar_cnpj() {
		this.nao_deve_aceitar_cnpj_nulo();
		this.nao_deve_aceitar_cnpj_maior_que_14_caracteres();
		this.nao_deve_aceitar_cnpj_menor_que_14_caracteres();
		this.nao_deve_aceitar_letras_no_cnpj();
		this.cnpj_nao_deve_conter_espacos();
		this.cnpj_deve_ser_valido();
	}

	@Test
	void testar_codigo_de_natureza_juridica() {
		this.natureza_juridica_nao_deve_ser_nula();
		this.codigo_de_natureza_juridica_nao_deve_passar_de_4_digitos();
		this.nao_deve_aceitar_letras_no_codigo_de_natureza_juridica();
	}

	@Test
	void nao_deve_aceitar_nome_fantasia_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setNomeFantasia(null);
		});
	}

	@Test
	void porte_da_empresa_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setPorte(null);
		});
	}

	@Test
	void nao_deve_aceitar_razao_social_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setRazaoSocial(null);
		});
	}

	@Disabled("Este teste não funciona adequadamente")
	@Test
	void banco_de_dados_deve_ser_acessado_com_sucesso() {
		assertEquals("Alexandre", empresa.getUsuario());
	}

	@Test
	void nao_deve_ultrapassar_o_limite_de_caracteres() {
		this.string_ente_federetivo();
		this.string_natureza_juridica();
		this.string_nome_fantasia();
		this.string_porte();
		this.string_razao_social();
	}

	@Test
	void toString_deve_retornar_corretamente() {
		assertEquals(
				"Empresa [cnpj=58119371000410, razaoSocial=SOFTMATIC SISTEMAS AUTOMATICOS DE INFORMATICA LTDA, nomeFantasia=CONTMATIC PHOENIX, codNatJuridica=2062, natJuridica=Sociedade Empresária Limitada, porte=DEMAIS, enteFederativo=null]",
				empresa.toString());
	}

	@Test
	void nao_deve_aceitar_codigo_de_natureza_juridica_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setCodNatJuridica(null);
		});
	}

	@Test
	void nao_deve_aceitar_situacao_cadastral_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setSituacaoCadastral(null);
		});
	}

	@Test
	void nao_deve_aceitar_contato_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setContato(null);
		});
	}

	@Test
	void nao_deve_aceitar_endereco_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setEndereco(null);
		});
	}

	@Test
	void nao_deve_aceitar_atividade_nula() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setAtividade(null);
		});
	}

	@Test
	void nao_deve_aceitar_situacao_especial_nula() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setSituacaoEspecial(null);
		});
	}

	@Test
	void nao_deve_aceitar_usuario_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setUsuario(null);
		});
	}
	
	@Test
	void nao_deve_aceitar_data_invalida() {
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		assertThrows(IllegalStateException.class, () ->{
			empresa.setDataAbertura(calendar.getTime());
		});
	}
	
	@Test
	void teste_equals_hashcode() {
		assertEquals(true,empresa.equals(empresa));
		assertEquals(false,empresa.equals(null));
		assertEquals(false,empresa.equals(1));
		assertEquals(false,empresa.equals(empresa3));
		assertEquals(false,empresa4.equals(empresa));
		assertEquals(true,empresa.equals(empresa2));
		assertEquals(true,empresa4.equals(empresa5));
		assertEquals(true, empresa.hashCode() == empresa2.hashCode());
		assertEquals(false, empresa4.hashCode() == empresa2.hashCode());	
	}

	private void string_porte() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setPorte(
					"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit. Morbi scelerisque luctus velit. Etiam dui sem, fermentum vitae, sagittis id, malesuada in, quam. Proin mattis lacinia justo. Vestibulum facilisis auctor urna. Aliquam in lorem sit amet leo accumsan lacinia. Integer rutrum, orci vestibulum ullamcorper ultricies, lacus quam ultricies odio, vitae placerat pede sem sit amet enim. Phasellus et lorem id felis nonummy placerat. Fusce dui leo, imperdiet in, aliquam sit amet, feugiat eu, orci. Aenean vel massa quis mauris vehicula lacinia. Quisque tincidunt scelerisque libero. Maecenas libero. Etiam dictum tincidunt diam. Donec ipsum massa, ullamcorper in, auctor et, scelerisque sed, est. Suspendisse nisl. Sed convallis magna eu sem. Cras pede libero, dapibus nec, pretium sit amet, tempor quis, urna. Aenean placerat. In vulputate urna eu arcu. Aliquam erat volutpat. Suspendisse potenti. Morbi mattis felis at nunc. Duis viverra diam non justo. In nisl. Nullam sit amet magna in magna gravida vehicula. Mauris tincidunt sem sed arcu. Nunc posuere. Nullam lectus justo, vulputate eget, mollis sed, tempor sed, magna. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam neque. Curabitur ligula sapien, pulvinar a, vestibulum quis, facilisis vel, sapien. Nullam eget nisl. Donec vitae arcu.\r\n"
							+ "\r\n"
							+ " Praesent in mauris eu tortor porttitor accumsan. Mauris suscipit, ligula sit amet pharetra semper, nibh ante cursus purus, vel sagittis velit mauris vel metus. Aenean fermentum risus id tortor. Integer imperdiet lectus quis justo. Integer tempor. Vivamus ac urna vel leo pretium faucibus. Mauris elementum mauris vitae tortor. In dapibus augue non sapien.");
		});
	}

	private void string_natureza_juridica() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setNatJuridica(
					"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit. Morbi scelerisque luctus velit. Etiam dui sem, fermentum vitae, sagittis id, malesuada in, quam. Proin mattis lacinia justo. Vestibulum facilisis auctor urna. Aliquam in lorem sit amet leo accumsan lacinia. Integer rutrum, orci vestibulum ullamcorper ultricies, lacus quam ultricies odio, vitae placerat pede sem sit amet enim. Phasellus et lorem id felis nonummy placerat. Fusce dui leo, imperdiet in, aliquam sit amet, feugiat eu, orci. Aenean vel massa quis mauris vehicula lacinia. Quisque tincidunt scelerisque libero. Maecenas libero. Etiam dictum tincidunt diam. Donec ipsum massa, ullamcorper in, auctor et, scelerisque sed, est. Suspendisse nisl. Sed convallis magna eu sem. Cras pede libero, dapibus nec, pretium sit amet, tempor quis, urna. Aenean placerat. In vulputate urna eu arcu. Aliquam erat volutpat. Suspendisse potenti. Morbi mattis felis at nunc. Duis viverra diam non justo. In nisl. Nullam sit amet magna in magna gravida vehicula. Mauris tincidunt sem sed arcu. Nunc posuere. Nullam lectus justo, vulputate eget, mollis sed, tempor sed, magna. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam neque. Curabitur ligula sapien, pulvinar a, vestibulum quis, facilisis vel, sapien. Nullam eget nisl. Donec vitae arcu.\r\n"
							+ "\r\n"
							+ " Praesent in mauris eu tortor porttitor accumsan. Mauris suscipit, ligula sit amet pharetra semper, nibh ante cursus purus, vel sagittis velit mauris vel metus. Aenean fermentum risus id tortor. Integer imperdiet lectus quis justo. Integer tempor. Vivamus ac urna vel leo pretium faucibus. Mauris elementum mauris vitae tortor. In dapibus augue non sapien.");
		});
	}

	private void string_nome_fantasia() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setNomeFantasia(
					"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit. Morbi scelerisque luctus velit. Etiam dui sem, fermentum vitae, sagittis id, malesuada in, quam. Proin mattis lacinia justo. Vestibulum facilisis auctor urna. Aliquam in lorem sit amet leo accumsan lacinia. Integer rutrum, orci vestibulum ullamcorper ultricies, lacus quam ultricies odio, vitae placerat pede sem sit amet enim. Phasellus et lorem id felis nonummy placerat. Fusce dui leo, imperdiet in, aliquam sit amet, feugiat eu, orci. Aenean vel massa quis mauris vehicula lacinia. Quisque tincidunt scelerisque libero. Maecenas libero. Etiam dictum tincidunt diam. Donec ipsum massa, ullamcorper in, auctor et, scelerisque sed, est. Suspendisse nisl. Sed convallis magna eu sem. Cras pede libero, dapibus nec, pretium sit amet, tempor quis, urna. Aenean placerat. In vulputate urna eu arcu. Aliquam erat volutpat. Suspendisse potenti. Morbi mattis felis at nunc. Duis viverra diam non justo. In nisl. Nullam sit amet magna in magna gravida vehicula. Mauris tincidunt sem sed arcu. Nunc posuere. Nullam lectus justo, vulputate eget, mollis sed, tempor sed, magna. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam neque. Curabitur ligula sapien, pulvinar a, vestibulum quis, facilisis vel, sapien. Nullam eget nisl. Donec vitae arcu.\r\n"
							+ "\r\n"
							+ " Praesent in mauris eu tortor porttitor accumsan. Mauris suscipit, ligula sit amet pharetra semper, nibh ante cursus purus, vel sagittis velit mauris vel metus. Aenean fermentum risus id tortor. Integer imperdiet lectus quis justo. Integer tempor. Vivamus ac urna vel leo pretium faucibus. Mauris elementum mauris vitae tortor. In dapibus augue non sapien.");
		});
	}

	private void string_ente_federetivo() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setEnteFederativo(
					"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit. Morbi scelerisque luctus velit. Etiam dui sem, fermentum vitae, sagittis id, malesuada in, quam. Proin mattis lacinia justo. Vestibulum facilisis auctor urna. Aliquam in lorem sit amet leo accumsan lacinia. Integer rutrum, orci vestibulum ullamcorper ultricies, lacus quam ultricies odio, vitae placerat pede sem sit amet enim. Phasellus et lorem id felis nonummy placerat. Fusce dui leo, imperdiet in, aliquam sit amet, feugiat eu, orci. Aenean vel massa quis mauris vehicula lacinia. Quisque tincidunt scelerisque libero. Maecenas libero. Etiam dictum tincidunt diam. Donec ipsum massa, ullamcorper in, auctor et, scelerisque sed, est. Suspendisse nisl. Sed convallis magna eu sem. Cras pede libero, dapibus nec, pretium sit amet, tempor quis, urna. Aenean placerat. In vulputate urna eu arcu. Aliquam erat volutpat. Suspendisse potenti. Morbi mattis felis at nunc. Duis viverra diam non justo. In nisl. Nullam sit amet magna in magna gravida vehicula. Mauris tincidunt sem sed arcu. Nunc posuere. Nullam lectus justo, vulputate eget, mollis sed, tempor sed, magna. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam neque. Curabitur ligula sapien, pulvinar a, vestibulum quis, facilisis vel, sapien. Nullam eget nisl. Donec vitae arcu.\r\n"
							+ "\r\n"
							+ " Praesent in mauris eu tortor porttitor accumsan. Mauris suscipit, ligula sit amet pharetra semper, nibh ante cursus purus, vel sagittis velit mauris vel metus. Aenean fermentum risus id tortor. Integer imperdiet lectus quis justo. Integer tempor. Vivamus ac urna vel leo pretium faucibus. Mauris elementum mauris vitae tortor. In dapibus augue non sapien.");
		});
	}

	private void string_razao_social() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setRazaoSocial(
					"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Morbi gravida libero nec velit. Morbi scelerisque luctus velit. Etiam dui sem, fermentum vitae, sagittis id, malesuada in, quam. Proin mattis lacinia justo. Vestibulum facilisis auctor urna. Aliquam in lorem sit amet leo accumsan lacinia. Integer rutrum, orci vestibulum ullamcorper ultricies, lacus quam ultricies odio, vitae placerat pede sem sit amet enim. Phasellus et lorem id felis nonummy placerat. Fusce dui leo, imperdiet in, aliquam sit amet, feugiat eu, orci. Aenean vel massa quis mauris vehicula lacinia. Quisque tincidunt scelerisque libero. Maecenas libero. Etiam dictum tincidunt diam. Donec ipsum massa, ullamcorper in, auctor et, scelerisque sed, est. Suspendisse nisl. Sed convallis magna eu sem. Cras pede libero, dapibus nec, pretium sit amet, tempor quis, urna. Aenean placerat. In vulputate urna eu arcu. Aliquam erat volutpat. Suspendisse potenti. Morbi mattis felis at nunc. Duis viverra diam non justo. In nisl. Nullam sit amet magna in magna gravida vehicula. Mauris tincidunt sem sed arcu. Nunc posuere. Nullam lectus justo, vulputate eget, mollis sed, tempor sed, magna. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Etiam neque. Curabitur ligula sapien, pulvinar a, vestibulum quis, facilisis vel, sapien. Nullam eget nisl. Donec vitae arcu.\r\n"
							+ "\r\n"
							+ " Praesent in mauris eu tortor porttitor accumsan. Mauris suscipit, ligula sit amet pharetra semper, nibh ante cursus purus, vel sagittis velit mauris vel metus. Aenean fermentum risus id tortor. Integer imperdiet lectus quis justo. Integer tempor. Vivamus ac urna vel leo pretium faucibus. Mauris elementum mauris vitae tortor. In dapibus augue non sapien.");
		});
	}

	private void deve_aceitar_usuario_valido() {
		assertEquals("Alexandre", empresa.getUsuario());
	}

	private void deve_aceitar_data_de_alteracao_valida() {
		empresa.setDataAlteracao(new Date());
		assertEquals(new Date(), empresa.getDataAlteracao());
	}

	private void deve_aceitar_data_de_cadastro_valida() {
		empresa.setDataCadastro(new Date());
		assertEquals(new Date(), empresa.getDataCadastro());
	}

	private void deve_aceitar_ip_valido() {
		assertEquals("192.168.0.1", empresa.getIp());
	}

	private void deve_aceitar_contato_valido() {
		assertEquals(new Contato("FINANCEIRO@CONTMATIC.COM.BR", telefone), empresa.getContato());
	}

	private void deve_aceitar_endereço_valido() {
		assertEquals(new Endereco("R MAJOR VAZ", municipio, "VILA ADYANA", "12243670"), empresa.getEndereco());
	}

	private void deve_aceitar_atividade_valida() {
		assertEquals(
				new Atividade("6203100",
						"Desenvolvimento e licenciamento de programas de computador não-customizáveis"),
				empresa.getAtividade());
	}

	private void deve_aceitar_situacao_cadastral_valida() {
		assertEquals(new SituacaoCadastral("", "ATIVA", new Date()), empresa.getSituacaoCadastral());
	}

	private void deve_aceitar_situacao_especial_valida() {
		assertEquals(new SituacaoEspecial("INATIVA", new Date()), empresa.getSituacaoEspecial());
	}

	private void deve_aceitar_ente_federativo_valido() {
		empresa.setEnteFederativo("Henrique Teste Nogueira");
		assertEquals("Henrique Teste Nogueira", empresa.getEnteFederativo());
	}

	private void deve_aceitar_empresa_valida() {
		assertEquals("58119371000410", empresa.getCnpj());
	}

	private void deve_aceitar_nome_fantasia_valido() {
		assertEquals("CONTMATIC PHOENIX", empresa.getNomeFantasia());
	}

	private void deve_aceitar_razao_social_valida() {
		assertEquals("SOFTMATIC SISTEMAS AUTOMATICOS DE INFORMATICA LTDA", empresa.getRazaoSocial());
	}

	private void deve_aceitar_codigo_de_nat_juridica_valido() {
		assertEquals("2062", empresa.getCodNatJuridica());
	}

	private void deve_aceitar_nat_juridica_valida() {
		assertEquals("Sociedade Empresária Limitada", empresa.getNatJuridica());
	}

	private void deve_aceitar_porte_valido() {
		assertEquals("DEMAIS", empresa.getPorte());
	}

	private void deve_aceitar_data_valida() {
		empresa.setDataAbertura(new Date());
		assertEquals(new Date(), empresa.getDataAbertura());
	}

	private void cnpj_nao_deve_conter_espacos() {
		assertThrows(IllegalArgumentException.class, () -> {
			empresa.setCnpj("     ");
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