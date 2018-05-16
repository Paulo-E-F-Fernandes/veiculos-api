Para esse projeto foi criado uma API Rest utilizando Java e Spring Boot no back-end. Para o front-end foi criado um app Angular junto com
PrimeNG. Como servidor foi utilizado o Apache Tomcat 9.0.8, já para o gerenciamento de dependências e build do back-end foi utilizado o Maven
e no front-end o Angular CLI.

* Passos para realizar o build e deploy da API:
1. Baixar o projeto da API (https://github.com/Paulo-E-F-Fernandes/veiculos-api);
2. Abrir o terminal no diretório raiz do projeto que foi baixado e executar o comando "mvn clean install";
3. Abrir o Tomcat (http://localhost:8080/) e depois o "Manager app" e fazer o deploy do arquivo "veiculos-api.war" que se encontra no
diretório "target" do projeto da API.

* Passos para realizar o build e deploy da UI:
1. Baixar o projeto da ui (https://github.com/Paulo-E-F-Fernandes/veiculos-ui);
	OBS.: É necessário possuir o "Angular CLI" instalado.
2. Abrir o terminal no diretório do projeto UI e executar o comando "ng build --prod --base-href http://localhost:8080/veiculos/";
	OBS.: Os arquivos do "app angular" serão gerados no diretório "dist". 
3. Criar o diretório "veiculos" no diretório "webapps" da instalação do Tomcat e colar todos os arquivos do diretório "dist";
4. Acessar no browser a url http://localhost:8080/veiculos/index.html, acessando assim o sistema.

OBS.: Usei a URL base http://localhost:8080 pois os serviços do angular estão apontandos para essa URL. Para alterar o local em que será 
publica a API, será necessário alterar a variável "recursoUrl" tanto do "MontadoraService" quanto do "VeiculoService".