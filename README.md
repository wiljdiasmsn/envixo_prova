# Envixo - DEV Java - Teste springboot-postgresql-hibernate-crud
Spring Boot, PostgreSQL, JPA, Hibernate RESTful CRUD API

Para iniciar o projeto siga os passos abaixo:

* Abra o pgAdmin do PostgreSQL e crie uma nova base de dados chamada "envixo_ecommerce";
* Abra o arquivo "src/main/resources/application.properties" e configure:
  * "spring.datasource.url": Hoste, e porta do PostgreSQL; 
  * "spring.datasource.username": Usuário do PostgreSQL;
  * "spring.datasource.password": Senha do PostgreSQL;
  * "server.port": Caso já esteja utilizando a porta 8081, configure uma porta livre;
* Abra o arquivo "start.cmd" e configure o JAVA_PATH para o caminho do seu computador;
* Abra o Terminal do Windows e execute o "start.cmd". 
* Utilize o projeto postman localizado na raiz do projeto para realizar os testes da aplicação.