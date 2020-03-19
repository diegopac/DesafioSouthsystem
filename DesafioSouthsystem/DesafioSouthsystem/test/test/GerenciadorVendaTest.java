package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.desafio.negocio.GerenciadorVenda;
import com.desafio.persistencia.Venda;

public class GerenciadorVendaTest {
	
	private GerenciadorVenda gerenciadorVenda;
	
	private List<String> listaDadosVenda = 
			Arrays.asList(new String[]{"003", "4", "[1-10-100,2-30-2.50,3-40-3.10]","João"});
	private List<String> listaDadosVenda2 = 
			Arrays.asList(new String[]{"003", "2", "[1-34-10,2-33-1.50,3-40-0.10]","Carlos"});
	private List<String> listaDadosVenda3 = 
			Arrays.asList(new String[]{"003", "35", "[1-5-11.5,2-4-1.50,3-11-0.15]","José"});
	private List<String> listaDadosVenda4 = 
			Arrays.asList(new String[]{"001", "17", "[1-27-11.5,2-45-1.50,3-41-0.15]","Adriano"});	// Venda invalida
	
	
	@Before
	public void setup() {
		gerenciadorVenda = GerenciadorVenda.getInstance();
	}
	
	@After
	public void after() {
		gerenciadorVenda.limparCache();
	}

	
	@Test
	public void testSeAdicionouVendasCorretamenteNaLista() {
		gerenciadorVenda.parseDadosVenda(listaDadosVenda);
		gerenciadorVenda.parseDadosVenda(listaDadosVenda2);
		gerenciadorVenda.parseDadosVenda(listaDadosVenda3);
		gerenciadorVenda.parseDadosVenda(listaDadosVenda4);
		List<Venda> listaVenda = gerenciadorVenda.obterListaVenda();
		assertEquals(3, listaVenda.size());
	}
	
	@Test
	public void testObterNomePiorVendedor() {
		gerenciadorVenda.parseDadosVenda(listaDadosVenda);
		gerenciadorVenda.parseDadosVenda(listaDadosVenda2);
		gerenciadorVenda.parseDadosVenda(listaDadosVenda3);
		gerenciadorVenda.parseDadosVenda(listaDadosVenda4);
		assertEquals("José", gerenciadorVenda.obterNomePiorVendedor());
	}
	
	@Test
	public void testObterIdVendaMaisCara() {
		gerenciadorVenda.parseDadosVenda(listaDadosVenda);
		gerenciadorVenda.parseDadosVenda(listaDadosVenda2);
		gerenciadorVenda.parseDadosVenda(listaDadosVenda3);
		gerenciadorVenda.parseDadosVenda(listaDadosVenda4);
		assertEquals("4", gerenciadorVenda.obterIdVendaMaisCara());
	}
}
