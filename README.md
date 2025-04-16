<h1 align="center"> CrudSpring</h1>

<p align="center">
  <a href="https://www.java.com/">
    <img alt="Java" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white">
  </a>
  <a href="https://spring.io/projects/spring-boot">
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white">
  </a>
  <a href="https://maven.apache.org/">
    <img alt="Build with Maven" src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white">
  </a>
  <a href="https://flywaydb.org/">
    <img alt="Flyway" src="https://img.shields.io/badge/Flyway-1B7B42?style=for-the-badge&logo=flyway&logoColor=white">
  </a>
  <a href="https://www.postgresql.org/">
    <img alt="PostgreSQL" src="https://img.shields.io/badge/PostgreSQL-336791?style=for-the-badge&logo=postgresql&logoColor=white">
  </a>
    <a href="https://www.postman.com/">
    <img alt="Postman" src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white">
    </a>
</p>

> 🛠️ Projeto desenvolvido como parte do programa **Joinville +tec**, com o objetivo de praticar o uso do **Spring Framework**, **APIs Rest** e integração com banco de dados.

##  Descrição

Este repositório contém uma **API Rest** de um **CRUD** com o intuito de gerenciar os **Projetos Sustentáveis** de suas respectivas organizações, foi desenvolvido utilizando **Spring Boot**, **Flyway** e **PostgreSQL**.  
O foco principal do projeto é o aprendizado e a prática de conceitos essenciais de **Back-end com Java**, incluindo a persistência de dados em um banco de dados relacional, automação de migrações de banco com o Flyway, **padrão MVC** e conceitos da arquitetura **REST**.

##  Tecnologias

-  **Java 21**
-  **Spring Boot** – Web, DevTools, Lombok, JPA
-  **Maven** – Gerenciador de dependências e build
- ️**Flyway** – Ferramenta de migração de banco de dados
-  **PostgreSQL** – Banco de dados relacional
-  **Postman** – Plataforma para teste de APIs


##  Endpoints e Funcionalidades Disponíveis

 ####  Projects
| Método | Endpoint                          | Descrição                            | Parâmetros de Query          |
|--------|-----------------------------------|--------------------------------------|------------------------------|
| GET    | `/projects`                      | Lista todos os projetos              | `?region=Sudeste` (opcional) |
| GET    | `/projects/{id}`                 | Busca um projeto por ID              | -                            |
| POST   | `/projects`                      | Cria um novo projeto                 | -                            |
| PUT    | `/projects/{id}`                 | Atualiza um projeto existente por id | -                            |
| DELETE | `/projects/{id}`                 | Remove um projeto                    | -                            |

 ####  Organizations
| Método | Endpoint                        | Descrição                                | Parâmetros de Query        |
|--------|---------------------------------|------------------------------------------|----------------------------|
| GET    | `/organizations`               | Lista todas as organizações              | `?name=ABC` (opcional)     |
| GET    | `/organizations/{id}`          | Busca uma organização por ID             | -                          |
| POST   | `/organizations`               | Cria uma nova organização                | -                          |
| PUT    | `/organizations/{id}`          | Atualiza uma organização existente por id | -                          |
| DELETE | `/organizations/{id}`          | Remove uma organização                   | -                          |

###  Filtros Especiais:
- **Buscar projetos por região**:  
  `GET /projects?region=Sudeste`

- **Buscar organizações por nome**:  
  `GET /organizations?name=Ecotech`  



##  Como Executar

###  Pré-requisitos

- **Java JDK 21**
- **PostgreSQL**
-  **Git**

###  Passos para rodar

**1. Clone o repositório:**

```bash
git clone https://github.com/louisemorais/CrudSpring.git
cd CrudSpring
```
**2. Crie o banco vazio no PostgreSQL**:
   ```sql
   CREATE DATABASE crudspring;
```
**3. Edite o arquivo ``application.properties``:**
```
### Banco de dados ###
spring.datasource.url=${DB_URL} //url com o nome do seu banco
spring.datasource.username=${DB_USERNAME} // seu username do banco
spring.datasource.password=${DB_PASSWORD}//sua senha do postgre

### JPA/Hibernate ###
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

### Flyway ###
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration

### Jackson(JSON) ###
spring.jackson.serialization.fail-on-empty-beans=false
spring.jackson.default-property-inclusion=non_null

### Logs ###
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```


**4. Execute a aplicação com Maven Wrapper:**

#### Linux/macOS

```bash
./mvnw spring-boot:run
```

####  Windows

```bash
mvnw.cmd spring-boot:run
```
<br>

---


##  Desenvolvedora

<p align="center">
  <a href="https://github.com/louisemorais">
    <img src="https://github.com/louisemorais.png" width="120" style="border-radius: 50%;" alt="Louise Morais"/>
  </a>
</p>

<p align="center">
  Feito com 💙 por <a href="https://github.com/louisemorais"> louisemorais</a><br
  ><a href="https://www.linkedin.com/in/louisemorais/"><img style="margin-top: 12px" src="https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn"/>

</p>
