package com.desafio.negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.desafio.persistencia.dominio.DominioTipoDado;

/**
 * 
 * @author diego.pacheco
 *
 */
public class Parser {
	
	private static final String SEPARADOR = "ç";
	private static final Integer NUMERO_COLUNAS = 4;

	
	public static void parseLinhas(List<String> listaLinhas) {
		
		Integer i = 0;
		for (String linha : listaLinhas) {
			List<String> listaDados = new ArrayList<String>();
			if (StringUtils.isNotEmpty(linha)) {
				String[] strDados = linha.split(SEPARADOR);
				if (strDados.length == NUMERO_COLUNAS) {
					listaDados = Arrays.asList(strDados);
					parseDadosDaLinha(listaDados);
				} else {
					// Poderia lancar excecao aqui tambem caso seja considerado critico
					System.out.println("[ERRO]: Nao foi encontrado o numero de colunas esperado. Linha: " + i);
				}
			}
			i++;
		}
	}
	
	private static void parseDadosDaLinha(List<String> listaDados) {
		DominioTipoDado dominioTipoDado = 
				DominioTipoDado.fromString(listaDados.get(0));

			switch (dominioTipoDado) {
			case ID_VENDEDOR: 
				GerenciadorVendedor.getInstance().parseDadosVendedor(listaDados);
				break;
			
			case ID_CLIENTE: 
				GerenciadorCliente.getInstance().parseDadosCliente(listaDados);
				break;		
				
			case ID_VENDA: 
				GerenciadorVenda.getInstance().parseDadosVenda(listaDados);
				break;					
				
			default:
				break;
			}
	}
	
}
