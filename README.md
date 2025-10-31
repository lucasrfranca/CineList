## ✨ CineList: Gerenciador Pessoal de Filmes

O **CineList** é uma aplicação web completa desenvolvida com Spring Boot para gerenciamento de um acervo pessoal de filmes. Ele permite que o usuário crie uma conta e realize o **CRUD (Create, Read, Update e Delete)** de seus filmes, registrando notas, diretores e etc.

## 🚀 Tecnologias e Dependências

O projeto é construído sobre o ecossistema Spring Boot, utilizando o padrão MVC (Model-View-Controller) e Persistência de Dados (JPA/Hibernate).

| Categoria | Tecnologia | Versão/Uso |
| :--- | :--- | :--- |
| **Backend** | Java | JDK 17+ (Desenvolvido com JDK 25) |
| **Framework** | Spring Boot | 3.x (Estrutura e Configuração) |
| **Persistência** | Spring Data JPA / Hibernate | Mapeamento Objeto-Relacional e persistência no MySQL. |
| **Banco de Dados** | MySQL | Banco de dados relacional. |
| **Template Engine**| Thymeleaf | Renderização dinâmica das páginas HTML. |
| **Estilização** | CSS3 | Dark Mode, Layout Flexbox e Grid. |
| **Ícones** | Font Awesome | 6.x (Ícones de ação, estrelas de avaliação). |
| **Interatividade** | JavaScript | Lógica para gerenciar Modais de Cadastro/Edição e confirmação de Exclusão. |
| **Build Tool** | Maven | Gerenciamento de dependências (`pom.xml`). |

---

## 🏗️ Estrutura de Arquivos

A arquitetura do projeto segue o padrão MVC do Spring Boot, com a adição do script do banco de dados na pasta resources.
					
```yaml
/cinelist
├── src/main/java
│   └── com/cinelist
│       ├── controller  # Lógica de Roteamento (CinelistController.java)
│       ├── model       # Entidades JPA (Filme.java, Usuario.java)
│       ├── repository  # Interfaces Spring Data JPA
│       └── service     # Lógica de Negócio (FilmeService.java)
├── src/main/resources
│   ├── db_schema.sql # Script SQL para a criação das tabelas.
│   ├── static
│   │   ├── css
│   │   │   ├── style.css
│   │   │   └── style_acervo.css
│   │   ├── js
│   │   │   └── acervo.js  # Lógica dos Modais e Interações
│   │   └── images
│   │       ├── logo.png
|	|		└── icone.png
│   └── templates
│       ├── login.html
│       ├── cadastro.html
│       └── acervo.html
└── pom.xml
```

## ⚙️ Como Rodar a Aplicação Localmente

### Pré-requisitos

1.  **JDK (Java Development Kit)**: Versão 17 ou superior(utilizei o 25).
   
2.  **IDE:** IntelliJ IDEA, VS Code ou Eclipse (recomendado para projetos Spring Boot).
   
3.  **SGBD (Sistema Gerenciador de Banco de Dados):** MySQL.
   
4.  **Driver MySQL:** É possível fazer o download da versão mais recente no link: https://dev.mysql.com/downloads/connector/j/. Após isso, só adicionar o arquivo baixado na pasta Maven Dependencies.

### 1. Configuração e Criação do Banco de Dados

Para iniciar a aplicação, você deve ter o banco de dados e as tabelas criadas:

1.	**Localize o Script SQL:** O arquivo contendo os comandos `CREATE TABLE` está em: `src/main/resources/db_schema.sql`

2.	**Execute o Script:** Use o MySQL Workbench, o terminal ou sua ferramenta de banco de dados favorita para executar os comandos neste arquivo. O script criará o banco de dados `cinelist_db` e as tabelas `usuario` e `filme`.

3.  **Configuração da Conexão:** No arquivo `src/main/resources/application.properties`, defina as credenciais do seu banco de dados local.
   
```yaml
# Caminho: src/main/resources/application.properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/cinelist_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
server.port=8080
```
### 2. Execução do Spring Boot

```yaml
./mvnw spring-boot:run
```
Se tudo ocorrer bem, o aplicativo estará acessível em: http://localhost:8080/ (ou na porta escolhida)

### 3. Acessando as Páginas

* **Página de Cadastro:** http://localhost:8080/cadastro
* **Página de Login:** http://localhost:8080/login
* **Meu Acervo:** http://localhost:8080/acervo
