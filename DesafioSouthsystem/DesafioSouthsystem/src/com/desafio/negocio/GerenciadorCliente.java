package com.desafio.negocio;

import java.util.List;

import com.desafio.persistencia.Cliente;
import com.desafio.persistencia.cache.ClienteCache;
import com.desafio.persistencia.dominio.DominioTipoDado;


public class GerenciadorCliente {
	
    private static GerenciadorCliente instancia = null;
    
    
    private GerenciadorCliente() { 
    	
    } 
    
    public static GerenciadorCliente getInstance() { 
        if (instancia == null) {
        	instancia = new GerenciadorCliente();
        }
  
        return instancia; 
    }
	
	public void parseDadosCliente(List<String> listaDados) {
		if (DominioTipoDado.ID_CLIENTE.equals(DominioTipoDado
				.fromString(listaDados.get(0)))) {
			Cliente cliente = new Cliente(listaDados.get(1), listaDados.get(2),
					listaDados.get(3));
			ClienteCache.getInstance().getListCliente().add(cliente);
		}
	}
	
	public Integer obterQuantClientes() {
		return ClienteCache.getInstance().getListCliente().size();
	}
	
	public List<Cliente> obterListaCliente() {
		return ClienteCache.getInstance().getListCliente();
	}
	
	public void limparCache() {
		ClienteCache.getInstance().limparCache();
	}

}
