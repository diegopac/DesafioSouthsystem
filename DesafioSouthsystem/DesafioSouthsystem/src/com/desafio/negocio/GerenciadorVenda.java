package com.desafio.negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.desafio.persistencia.ItemVenda;
import com.desafio.persistencia.Venda;
import com.desafio.persistencia.cache.VendaCache;
import com.desafio.persistencia.dominio.DominioTipoDado;

public class GerenciadorVenda {
	
	private static final String BRACKET_INICIO = "[";
	private static final String BRACKET_FIM = "]";
	private static final String VIRGULA = ",";
	private static final String HIFEN = "-";
	
    private static GerenciadorVenda instancia = null;
    
    
    private GerenciadorVenda() { 
    	
    } 
    
    public static GerenciadorVenda getInstance() { 
        if (instancia == null) {
        	instancia = new GerenciadorVenda();
        }
  
        return instancia; 
    }
	
	public void parseDadosVenda(List<String> listaDados) {
		if (DominioTipoDado.ID_VENDA.equals(DominioTipoDado
				.fromString(listaDados.get(0)))) {
			String strItensVenda = listaDados.get(2);
			List<ItemVenda> listItemVenda = new ArrayList<ItemVenda>();
			if (StringUtils.isNotEmpty(strItensVenda)
					&& strItensVenda.startsWith(BRACKET_INICIO)
					&& strItensVenda.endsWith(BRACKET_FIM)) {
				
				strItensVenda = strItensVenda.replace(BRACKET_INICIO, "").replace(BRACKET_FIM, "");
				
				String[] itens = strItensVenda.split(VIRGULA);
				if (itens.length > 0) {
					List<String> listStrItens = Arrays.asList(itens);
					listItemVenda = parseDadosItemVenda(listStrItens);
				}
			}
			
			Double totalVenda = listItemVenda.stream()
					.map(s -> s.getPrice() * Double.parseDouble(s.getQuantity()))
					.collect(Collectors.summingDouble(Double::doubleValue));
			
			Venda venda = new Venda(listaDados.get(1), listItemVenda,
					listaDados.get(3), totalVenda);
			VendaCache.getInstance().getListVenda().add(venda);
		}
	}
	
	private static List<ItemVenda> parseDadosItemVenda(List<String> listStrItens) {
		List<ItemVenda> listItemVenda = new ArrayList<ItemVenda>();
		
		for (String strItem : listStrItens) {
			String[] dadosItem = strItem.split(HIFEN);
			if (dadosItem.length == 3) {
				ItemVenda itemVenda = new ItemVenda(
						dadosItem[0], dadosItem[1],
						Double.parseDouble(dadosItem[2]));
				listItemVenda.add(itemVenda);
			}
		}
		
		return listItemVenda;
	}	
	
	public String obterIdVendaMaisCara() {
		List<Venda> listVenda = obterListaVenda();
		Collections.sort(listVenda, Comparator.comparing(Venda::getTotalVenda).reversed());
		return listVenda.get(0).getId();
	}
	
	public String obterNomePiorVendedor() {
		List<Venda> listVenda = obterListaVenda();
		Collections.sort(listVenda,	Comparator.comparing(Venda::getTotalVenda));
		return listVenda.get(0).getSalesmanName();
	}
	
	public List<Venda> obterListaVenda() {
		return VendaCache.getInstance().getListVenda();
	}
	
	public void limparCache() {
		VendaCache.getInstance().limparCache();
	}

}
