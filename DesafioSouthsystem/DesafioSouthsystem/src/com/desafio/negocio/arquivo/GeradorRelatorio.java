package com.desafio.negocio.arquivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.desafio.negocio.GerenciadorCliente;
import com.desafio.negocio.GerenciadorVenda;
import com.desafio.negocio.GerenciadorVendedor;


/**
 * 
 * @author diego.pacheco
 *
 */
public class GeradorRelatorio {
	
	private static final String FORMATO_ARQ_SAIDA = ".done.dat";
	
	public static void gerarRelatorio(String nomeArquivo) {
		FileWriter fileWriter = null;
		GerenciadorVendedor gerenciadorVendedor = GerenciadorVendedor.getInstance();
		GerenciadorCliente gerenciadorCliente = GerenciadorCliente.getInstance();
		GerenciadorVenda gerenciadorVenda = GerenciadorVenda.getInstance();
		
		StringBuilder sb = new StringBuilder(50);
		sb.append("\n");
		sb.append("Quantidade de clientes no arquivo de entrada: "
				+ gerenciadorCliente.obterQuantClientes() + "\r\n");
		sb.append("Quantidade de vendedores no arquivo de entrada: "
				+ gerenciadorVendedor.obterQuantVendedores() + "\r\n");
		sb.append("ID da venda mais cara: " + gerenciadorVenda.obterIdVendaMaisCara() + "\r\n");
		sb.append("O pior vendedor: " + gerenciadorVenda.obterNomePiorVendedor() + "\r\n");
		sb.append("\n");
		
		try {
			String homePath = ValidadorDiretorio.obterHomepathDir();
			String caminhoArquivo = homePath + File.separatorChar
					+ "data" + File.separatorChar + "out" + File.separatorChar
					+ nomeArquivo + FORMATO_ARQ_SAIDA;
			fileWriter = new FileWriter(new File(caminhoArquivo));
			fileWriter.write(sb.toString());
			System.out.println("Relatorio gerado: " + caminhoArquivo);
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		gerenciadorVendedor.limparCache();
		gerenciadorCliente.limparCache();
		gerenciadorVenda.limparCache();
	}

}
