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

A arquitetura do projeto segue o padrão do Spring Boot para aplicações web, com todos os arquivos estáticos (CSS, JS, Imagens) localizados na pasta src/main/resources/static.
					
```yaml
/cinelist
├── src/main/java
│   └── ... (Futuros Controladores e Serviços Java)
├── src/main/resources
│   ├── static
│   │   ├── css
│   │   │   ├── style.css (Estilos gerais, Menu, Login/Cadastro)
│   │   │   └── style_acervo.html (Estilos Específicos do Catálogo)
│   │   ├── js
│   │   │   └── acervo.js (Lógica do Modal)
│   │   └── images
│   │       └── logo.png
│   ztemplates
│       ├── login.html
│       ├── cadastro.html
│       └── acervo.html (Página Principal do Catálogo)
└──pom.xml
```

## ⚙️ Como Rodar a Aplicação Localmente

### Pré-requisitos

1.  **JDK (Java Development Kit)**: Versão 17 ou superior(utilizei o 25).
2.  **IDE:** IntelliJ IDEA, VS Code ou Eclipse (recomendado para projetos Spring Boot).

### 1. Configuração do Banco de Dados

1.  Ter um SGBD instalado na sua maquina. No meu caso estou utilando o **MySQL Workbench** e para ele poder efetuar a conexão com o banco de dados é preciso ter o driver MySQL instalado nas dependências do projeto. É possível fazer o download da versão mais recente no link: https://dev.mysql.com/downloads/connector/j/ com base no seu OS. Após isso, só adicionar o arquivo baixado na pasta Maven Dependencies.
2.  Crie um banco com o nome cinelist_db.
3.  No arquivo src/main/resources/application.properties, defina a porta do servidor e os detalhes de conexão do seu banco de dados local.
```yaml
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
