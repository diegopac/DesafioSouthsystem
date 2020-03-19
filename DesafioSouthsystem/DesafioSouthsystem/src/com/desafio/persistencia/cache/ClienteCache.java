package com.desafio.persistencia.cache;

import java.util.ArrayList;
import java.util.List;

import com.desafio.persistencia.Cliente;

public class ClienteCache {
	
    private static ClienteCache instancia = null;
    private List<Cliente> listCliente = new ArrayList<Cliente>();
    
    
    private ClienteCache() { 
    	
    } 
    
    public static ClienteCache getInstance() { 
        if (instancia == null) {
        	instancia = new ClienteCache();
        }
  
        return instancia; 
    }

	public List<Cliente> getListCliente() {
		return listCliente;
	}
	
	public void limparCache() {
		listCliente = new ArrayList<Cliente>();
	}

}
