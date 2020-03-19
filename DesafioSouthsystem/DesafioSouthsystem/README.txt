

Essa aplicação é uma solução para o desafio proposto em: https://github.com/rh-southsystem/desafio-backend-arquivo

A aplicação pode ser executada em ambientes Windows e Linux, conforme passos abaixo:


* Configurar a variavel de ambiente HOMEPATH e os sub-diretorios "data/in" e "data/out" onde irão constar os arquivos de entrada e saída antes de executar a aplicação.

* Compilar pelo Maven (pom.xml)

* Executando em ambiente Windows:

	cd <caminho_da_aplicacao>\bin
	java -cp .;../lib/* com.desafio.aplicacao.Aplicacao


* Executando em ambiente Linux:

	cd <caminho_da_aplicacao>/bin
	java -cp .:../lib/* com.desafio.aplicacao.Aplicacao


IMPORTANTE: os arquivos .dat que serão lidos devem usar a codificação ANSI 