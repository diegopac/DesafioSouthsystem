package com.desafio.negocio.arquivo;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.Optional;

import com.desafio.negocio.Parser;

/**
 * 
 * @author diego.pacheco
 *
 */
public class DetectorArquivo {
	
	private static final String FORMATO_ARQ_ACEITO = ".dat";
	
	
	public void observarDiretorio() {
		try {
			String homePath = ValidadorDiretorio.obterHomepathDir();

			WatchService watcher = FileSystems.getDefault().newWatchService();
			
			Path diretorio = Paths.get(homePath + File.separatorChar + "data"
					+ File.separatorChar + "in" + File.separatorChar);

			diretorio.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);

			while (true) {
				WatchKey key = watcher.take();
				Optional<WatchEvent<?>> watchEvent = key.pollEvents().stream()
						.findFirst();
				Path path = (Path) watchEvent.get().context();
				String nomeFlatFile = path.getFileName().toString().replaceAll(FORMATO_ARQ_ACEITO, "");
				String strPathCompleto = diretorio.toString() + File.separatorChar + path.toString();
				if (strPathCompleto.toString().endsWith(FORMATO_ARQ_ACEITO)) {
					List<String> listLinhas = LeitorArquivo.lerArquivo(strPathCompleto);
					Parser.parseLinhas(listLinhas);
					GeradorRelatorio.gerarRelatorio(nomeFlatFile);
				}

				Boolean ok = key.reset();
				if (!ok) {
					break;
				}
			}
			
			watcher.close();

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
