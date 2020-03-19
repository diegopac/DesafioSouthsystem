package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.desafio.negocio.GerenciadorVendedor;
import com.desafio.persistencia.Vendedor;

public class GerenciadorVendedorTest {
	
	private GerenciadorVendedor gerenciadorVendedor;
	private List<String> listaDadosVendedor = 
			Arrays.asList(new String[]{"001", "1234567891234","Paulo Silva","2000"});
	private List<String> listaDadosVendedor2 = 
			Arrays.asList(new String[]{"001", "2222222222222","José Carlos","7000"});
	private List<String> listaDadosVendedor3 = 
			Arrays.asList(new String[]{"001", "7777777777777","João de Souza","200.99"});
	private List<String> listaDadosVendedor4 = 
			Arrays.asList(new String[]{"002", "8888888888888","Pedro Melo","1200"});	// Vendedor invalido
	
	
	@Before
	public void setup() {
		gerenciadorVendedor = GerenciadorVendedor.getInstance();
	}
	
	@After
	public void after() {
		gerenciadorVendedor.limparCache();
	}
	
	@Test
	public void testSeAdicionouVendedoresCorretamenteNaLista() {
		gerenciadorVendedor.parseDadosVendedor(listaDadosVendedor);
		gerenciadorVendedor.parseDadosVendedor(listaDadosVendedor2);
		gerenciadorVendedor.parseDadosVendedor(listaDadosVendedor3);
		gerenciadorVendedor.parseDadosVendedor(listaDadosVendedor4);
		List<Vendedor> listaVendedor = gerenciadorVendedor.obterListaVendedor();
		assertEquals(3, listaVendedor.size());
	}

	@Test
	public void testSePossuiQuantidadeCorretaNaLista() {
		gerenciadorVendedor.parseDadosVendedor(listaDadosVendedor);
		gerenciadorVendedor.parseDadosVendedor(listaDadosVendedor2);
		assertEquals(new Integer(2), gerenciadorVendedor.obterQuantVendedores());
	}
}
