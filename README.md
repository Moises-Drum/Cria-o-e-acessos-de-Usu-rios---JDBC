# Projeto criação de Usuário JDBC 

Este repositório aborda práticas relacionadas à troca de dados entre a linguagem Java e um banco de dados relacional. A conexão é estabelecida por meio da API JDBC (Java Database Connectivity) em conjunto com o Sistema Gerenciador de Banco de Dados (SGBD) MySQL.

## Preparativos

Antes de iniciar a aplicação, é essencial ter o módulo de conexão JDBC, as credenciais de acesso ao Sistema Gerenciador de Banco de Dados (SGBD) e o banco de dados devidamente configurado. Esses elementos são fundamentais para garantir uma conexão eficaz e a operação adequada da aplicação.
OBS. Caso haja dificuldade no download, existe uma pasta dentro da pasta que possui o códiogo Java que contém o módulo JDBC

1. Download JDBC Connector
URL: https://dev.mysql.com/downloads/connector/j/ <br><br>
  **1.1 - Passo 1** <br><br>
     <img src="/ImgTutorial/JDBC Connector/Passo 1.jpeg" width="550"/> <br><br>
  **1.2 - Passo 2** <br><br>
     <img src="/ImgTutorial/JDBC Connector/Passo 2.jpeg" width="550"/>

2. Configurando no Intellij <br><br>
   **2.1 - Passo 1** <br><br>
     <img src="/ImgTutorial/Config Intellij/Passo1.jpeg" width="550"/> <br><br>
   **2.2 - Passo 2** <br><br>
     <img src="/ImgTutorial/Config Intellij/Passo2.jpeg" width="550"/> <br><br>
   **2.3 - Passo 3** <br><br>
     <img src="/ImgTutorial/Config Intellij/Passo3.jpeg" width="550"/> <br><br>

3. Configurando conexão entre Java e BD <br><br>
   **5.1 - Detalhes na imagem** <br><br>
     <img src="/ImgTutorial/Config Java BD/passo 1.jpeg" width="550"/> <br><br>

## Aplicação

Após concluir todos os preparativos para a conexão entre Java e o Sistema Gerenciador de Banco de Dados (SGBD), você pode proceder com os testes para garantir o funcionamento adequado. Certifique-se de validar a integridade da conexão e a eficácia da troca de dados durante essa fase de teste.

## Estrutura

- A classe principal está nomeada como "Application". É nela q o os objetos serão executados. Ela conversa diretamente com a classe "Action" q realiza todas as condições necessárias para se criar um usuário. <br>
- A classe "Link" está responsável por criar a conexão, ou seja, cria a ponte entre o JAVA e o BD. <br>
- A classe "UserPessoa" serve como um pré armazenamento, o qual coleta os dados inseridos para a classe "Action" para ser utilizado mais tarde (Tipo um DTO em Spring Boot). <br>
- A Classe "Message" serve como uma base para mensagens padrão (Ironicamente só possuí uma mensagem padrão kkk). <br>

## Finalização

Este repositório representa apenas uma parcela dos estudos dedicados à conexão entre Java e o Banco de Dados. Sinta-se à vontade para explorar e aprofundar-se nesse campo de conhecimento.
