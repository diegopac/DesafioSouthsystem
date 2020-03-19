package com.desafio.persistencia.dominio;

public enum DominioTipoDado {
	
	ID_VENDEDOR ("001"),
	ID_CLIENTE ("002"),
	ID_VENDA ("003");
	
	
	private String valor;
	
	private DominioTipoDado(String valor) {
		this.setValue(valor);
	}

	public String getValue() {
		return valor;
	}

	public void setValue(String valor) {
		this.valor = valor;
	}
	
    public static DominioTipoDado fromString(String valor) {
        for (DominioTipoDado b : DominioTipoDado.values()) {
            if (b.valor.equals(valor)) {
                return b;
            }
        }
        return null;
    }

}
