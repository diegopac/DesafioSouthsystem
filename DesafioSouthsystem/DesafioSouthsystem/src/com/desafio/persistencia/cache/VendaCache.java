package com.desafio.persistencia.cache;

import java.util.ArrayList;
import java.util.List;

import com.desafio.persistencia.Venda;

public class VendaCache {
	
    private static VendaCache instancia = null;
    private List<Venda> listVenda = new ArrayList<Venda>();
    
    
    private VendaCache() { 
    	
    } 
    
    public static VendaCache getInstance() { 
        if (instancia == null) {
        	instancia = new VendaCache();
        }
  
        return instancia; 
    }

	public List<Venda> getListVenda() {
		return listVenda;
	}
	
	public void limparCache() {
		listVenda = new ArrayList<Venda>();
	}

}
