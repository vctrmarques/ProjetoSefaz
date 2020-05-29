Cadastro de Uusario
O objetivo dessa aplicação é permitir mostrar o cadastro de Usuario a partir de Usuario cadastrados na base de dados.

Frameworks utilizados:
 PostgreSQL DB
 JSF
 JPA
 Hibernate
 CSS
 Bootstrap
 Maven
 GIT
 
Roteiro básico de manuseio das telas do sistema.

Mostra a tela de login
http://localhost:8080/sefaz/login.jsf

Realiza o primeiro cadastro ou edita um usuario selecionado na tela mostraUsuario.jsf
http://localhost:8080/sefaz/usuario.jsf

Ao logar, lista os usuarios cadastrados
http://localhost:8080/sefaz/mostrarUsuario.jsf
 
 Roteiro básico de instalação

 Criar o schema "desafioSefaz" na base de dados;
 Definir um usuário com acesso de escrita e consulta ao novo schema; 
 Baixar código fonte: git clone Executar o script SQL que se encontra no diretório "sql";
 Editar o arquivo "pom.xml" atualizando as configurações da base de dados; 
 Executar o seguinte comando onde se encontra o arquivo pom.xml: mvn clean install
 git push -u origin master
