## ✨ Visão Geral do Projeto

O **CineList** é um sistema de gerenciamento de coleções de filmes, permitindo que o usuário cadastre, visualize e gerencie seus filmes favoritos com notas e detalhes.

Esta é a **versão inicial (Frontend/Layout)** do projeto, focada em entregar uma experiência de usuário (UX) moderna e funcional, com tema escuro (Dark Mode).

**⚠️ Status Atual:** Este repositório contém a **estrutura inicial do Frontend (HTML, CSS, JavaScript)**. As funcionalidades de back-end (lógica de negócio em Java/Spring Boot e persistência de dados) serão adicionadas em *updates* futuros.

## 🚀 Tecnologias e Dependências

O projeto utiliza o ecossistema Spring Boot, mas esta fase se concentra nas tecnologias de interface:

| Categoria | Tecnologia | Versão/Uso |
| :--- | :--- | :--- |
| **Backend** | Java | JDK 17+ (Recomendado) |
| **Framework** | Spring Boot | 3.x (Estrutura) |
| **Template Engine**| Thymeleaf/JSP | Usado para renderizar as páginas HTML |
| **Estilização** | CSS3 | Dark Mode, Flexbox (Layout dos Cards e Menu) |
| **Ícones** | Font Awesome | 6.x (Estrelas, Botões de Ação) |
| **Interatividade** | JavaScript | JS puro para Modal de Cadastro |
| **Build Tool** | Maven ou Gradle | Gerenciamento de dependências |

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

1.  **JDK (Java Development Kit)**: Versão 17 ou superior.
2.  **IDE:** IntelliJ IDEA, VS Code ou Eclipse (recomendado para projetos Spring Boot).

### 1. Configuração do Banco de Dados

1.  Ter um SGBD instalado na sua maquina. No meu caso eu estou utilando o **MySQL Workbench**
2.  **Git:** Instalado e configurado.
3.  **IDE:** IntelliJ IDEA, VS Code ou Eclipse (recomendado para projetos Spring Boot).
