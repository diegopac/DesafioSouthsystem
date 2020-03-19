package com.desafio.persistencia.cache;

import java.util.ArrayList;
import java.util.List;

import com.desafio.persistencia.Vendedor;

public class VendedorCache {
	
	private static VendedorCache instancia = null;
    private List<Vendedor> listVendedor = new ArrayList<Vendedor>();
    
    
    private VendedorCache() { 
    	
    } 
    
    public static VendedorCache getInstance() { 
        if (instancia == null) {
        	instancia = new VendedorCache();
        }
  
        return instancia; 
    }

	public List<Vendedor> getListVendedor() {
		return listVendedor;
	}
	
	public void limparCache() {
		listVendedor = new ArrayList<Vendedor>();
	}

}
