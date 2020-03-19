package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.desafio.negocio.GerenciadorCliente;
import com.desafio.persistencia.Cliente;

/**
 * 
 * @author diego.pacheco
 *
 */
public class GerenciadorClienteTest {
	
	private GerenciadorCliente gerenciadorCliente;
	private List<String> listaDadosCliente = 
			Arrays.asList(new String[]{"002", "1234567891234","Carlos Silva","Urbano"});
	private List<String> listaDadosCliente2 = 
			Arrays.asList(new String[]{"002", "2222222222222","Francisco Neto","Rural"});
	private List<String> listaDadosCliente3 = 
			Arrays.asList(new String[]{"002", "7777777777777","João de Souza","Urbano"});
	private List<String> listaDadosCliente4 = 
			Arrays.asList(new String[]{"001", "9999999999999","Adriano","Urbano"});		// Cliente invalido
	
	@Before
	public void setup() {
		gerenciadorCliente = GerenciadorCliente.getInstance();
	}
	
	@After
	public void after() {
		gerenciadorCliente.limparCache();
	}	
	
	@Test
	public void testSeAdicionouClientesCorretamenteNaLista() {
		gerenciadorCliente.parseDadosCliente(listaDadosCliente);
		gerenciadorCliente.parseDadosCliente(listaDadosCliente2);
		gerenciadorCliente.parseDadosCliente(listaDadosCliente3);
		gerenciadorCliente.parseDadosCliente(listaDadosCliente4);
		List<Cliente> listaCliente = gerenciadorCliente.obterListaCliente();
		assertEquals(3, listaCliente.size());
	}
	
	@Test
	public void testSePossuiQuantidadeCorretaNaLista() {
		gerenciadorCliente.parseDadosCliente(listaDadosCliente);
		gerenciadorCliente.parseDadosCliente(listaDadosCliente2);
		assertEquals(new Integer(2), gerenciadorCliente.obterQuantClientes());
	}

}
