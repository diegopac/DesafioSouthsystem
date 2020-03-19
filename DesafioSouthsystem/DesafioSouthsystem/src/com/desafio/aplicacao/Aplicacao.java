package com.desafio.aplicacao;

import com.desafio.negocio.arquivo.DetectorArquivo;

/**
 * 
 * @author diego.pacheco
 *
 */
public class Aplicacao {
	
	public void executarAplicacao() {
		System.out.println("Aplicação em execução.");
		new DetectorArquivo().observarDiretorio();
	}
	
	public static void main(String[] args) {
		new Aplicacao().executarAplicacao();
	}

}
