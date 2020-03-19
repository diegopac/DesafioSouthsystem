package com.desafio.persistencia;

import java.util.List;

/**
 * 
 * @author diego.pacheco
 *
 */
public class Venda {
	
	private String id;
	private List<ItemVenda> listaItemVenda;
	private String salesmanName;
	private transient Double totalVenda;

	
	public Venda(String id, List<ItemVenda> listaItemVenda, String salesmanName, Double totalVenda) {
		this.id = id;
		this.listaItemVenda = listaItemVenda;
		this.salesmanName = salesmanName;
		this.totalVenda = totalVenda;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ItemVenda> getListaItemVenda() {
		return listaItemVenda;
	}

	public void setListaItemVenda(List<ItemVenda> listaItemVenda) {
		this.listaItemVenda = listaItemVenda;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}
	
	public Double getTotalVenda() {
		return totalVenda;
	}

	public void setTotalVenda(Double totalVenda) {
		this.totalVenda = totalVenda;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", listaItemVenda=" + listaItemVenda
				+ ", salesmanName=" + salesmanName + "]";
	}
}
