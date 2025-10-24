🎬 CineList - Catálogo de Filmes

✨ Visão Geral do Projeto

O CineList é um sistema de gerenciamento de coleções de filmes, permitindo que o usuário cadastre, visualize e gerencie seus filmes favoritos com notas e detalhes.

Esta é a versão inicial (Frontend/Layout) do projeto, focada em entregar uma experiência de usuário (UX) moderna e funcional, com tema escuro (Dark Mode).

⚠️ Status Atual: Este repositório contém a estrutura inicial do Frontend (HTML, CSS, JavaScript). As funcionalidades de back-end (lógica de negócio em Java/Spring Boot e persistência de dados) serão adicionadas em updates futuros.

🚀 Tecnologias e Dependências

O projeto utiliza o ecossistema Spring Boot, mas esta fase se concentra nas tecnologias de interface:

🏗️ Estrutura de Arquivos

A arquitetura do projeto segue o padrão do Spring Boot para aplicações web, com todos os arquivos estáticos (CSS, JS, Imagens) localizados na pasta src/main/resources/static.
					
/cinelist
├── src/main/java
│   └── ... (Futuros Controladores e Serviços Java)
├── src/main/resources
│   ├── static
│   │   ├── css
│   │   │   ├── style.css (Login/Cadastro)
│   │   │   └── style_acervo.html (Estilos Específicos do Catálogo)
│   │   ├── js
│   │   │   └── acervo.js (Lógica do Modal)
│   │   └── images
│   │       └── logo.png
│   └── templates
│       ├── login.html
│       ├── cadastro.html
│       └── acervo.html (Página Principal do Catálogo)
├── pom.xml (ou build.gradle)
└── README.md					
					
					
