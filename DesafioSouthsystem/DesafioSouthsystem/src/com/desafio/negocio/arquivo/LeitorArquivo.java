package com.desafio.negocio.arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *  
 * @author diego.pacheco
 *
 */
public class LeitorArquivo {
	
	public static List<String> lerArquivo(String caminhoArquivo) {
		BufferedReader bufReader = null;
		List<String> listLinhas = new ArrayList<String>();
		
		try {
			// O arquivo a ser lido deve estar na codificação ANSI
			bufReader = new BufferedReader(new FileReader(caminhoArquivo));
			
			System.out.println("Lendo arquivo " + caminhoArquivo);
			
			String linha = bufReader.readLine();
			listLinhas.add(linha);
			while (linha != null) {
				linha = bufReader.readLine();
				listLinhas.add(linha);
			}
			
			bufReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		return listLinhas;
	}

}
