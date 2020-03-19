package com.desafio.negocio.arquivo;

import java.io.IOException;

public class ValidadorDiretorio {
	
	public static String obterHomepathDir() throws IOException {
		String homePath = System.getenv("HOMEPATH");

		if (homePath == null) {
			throw new IOException("HOMEPATH não foi encontrado!");
		}
		
		return homePath;
	}

}
