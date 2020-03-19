package com.desafio.negocio;

import java.util.List;

import com.desafio.persistencia.Vendedor;
import com.desafio.persistencia.cache.VendedorCache;
import com.desafio.persistencia.dominio.DominioTipoDado;

public class GerenciadorVendedor {
	
    private static GerenciadorVendedor instancia = null;
    
    
    private GerenciadorVendedor() { 
    	
    } 
    
    public static GerenciadorVendedor getInstance() { 
        if (instancia == null) {
        	instancia = new GerenciadorVendedor();
        }
  
        return instancia; 
    }
	
	public void parseDadosVendedor(List<String> listaDados) {
		if (DominioTipoDado.ID_VENDEDOR.equals(DominioTipoDado
				.fromString(listaDados.get(0)))) {
			Vendedor vendedor = new Vendedor(
					listaDados.get(1), listaDados.get(2), Double.parseDouble(listaDados.get(3)));
			VendedorCache.getInstance().getListVendedor().add(vendedor);
		}
	}
	
	public Integer obterQuantVendedores() {
		return VendedorCache.getInstance().getListVendedor().size();
	}
	
	public List<Vendedor> obterListaVendedor() {
		return VendedorCache.getInstance().getListVendedor();
	}
	
	public void limparCache() {
		VendedorCache.getInstance().limparCache();
	}

}
