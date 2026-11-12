
# 📦 CRUD JDBC - Gerenciamento de Produtos

## 📌 Sobre o Projeto

Este projeto foi desenvolvido como um exercício prático para consolidar os conhecimentos adquiridos em JDBC (Java Database Connectivity).

O sistema consiste em um CRUD de produtos integrado a um banco de dados MySQL, aplicando boas práticas de programação, organização de código, separação de responsabilidades e o padrão de projeto DAO (Data Access Object).

O principal objetivo é praticar a comunicação entre a aplicação e o banco de dados, reforçando os conceitos de persistência de dados e preparando a base para o estudo de JPA, Hibernate e Spring Boot.

## 🚀 Tecnologias Utilizadas

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-007396?style=for-the-badge&logo=java&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white)

- Java
- JDBC
- MySQL
- MySQL Connector/J
- Eclipse IDE
- Git e GitHub

## ⚙️ Funcionalidades

- ✅ Cadastro de produtos
- ✅ Busca de produtos por ID
- ✅ Listagem de todos os produtos
- ✅ Atualização de produtos
- ✅ Exclusão de produtos
- ✅ Conexão com banco de dados MySQL
- ✅ Tratamento de exceções
- ✅ Implementação do padrão DAO

## 🏗️ Estrutura do Projeto

```text
crud_jdbc/
│
├── src/
│   ├── application/
│   │   └── Program.java
│   │
│   ├── db/
│   │   ├── DB.java
│   │   └── DbException.java
│   │
│   └── model/
│       ├── entities/
│       │   └── Produto.java
│       │
│       └── dao/
│           ├── ProdutoDao.java
│           ├── DaoFactory.java
│           └── impl/
│               └── ProdutoDaoJDBC.java
│
├── lib/
│   └── mysql-connector-j.jar
│
├── db.example.properties
├── .gitignore
└── README.md
```

## 🧠 Conceitos Aplicados

Durante o desenvolvimento deste exercício, foram praticados os seguintes conceitos:

### JDBC

- Conexão com banco de dados utilizando DriverManager.
- Execução de comandos SQL.
- Utilização de PreparedStatement.
- Manipulação de resultados com ResultSet.
- Gerenciamento e fechamento de recursos.
- Tratamento de SQLException.

### Programação Orientada a Objetos

- Encapsulamento.
- Interfaces.
- Polimorfismo.
- Abstração.
- Separação de responsabilidades.
- Injeção de dependência.

### Padrão DAO

O projeto utiliza o padrão DAO para separar a lógica de acesso ao banco de dados da lógica da aplicação.

A interface ProdutoDao define as operações disponíveis, enquanto a classe ProdutoDaoJDBC implementa essas operações utilizando JDBC.

A classe DaoFactory é responsável pela criação das implementações DAO, facilitando a organização e reduzindo o acoplamento entre as classes.

## 🗄️ Banco de Dados

O sistema utiliza um banco de dados MySQL para armazenar os produtos.

### Estrutura da tabela

```sql
CREATE DATABASE crud_jdbc;

USE crud_jdbc;

CREATE TABLE produto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    quantidade INT NOT NULL
);
```

## 🔧 Como Executar o Projeto

### 1. Clone o repositório

```bash
git clone https://github.com/kelvineduardosilva/crud_jdbc.git
```

### 2. Importe o projeto

Abra o Eclipse IDE e importe o projeto Java.

### 3. Configure o banco de dados

Crie o banco de dados MySQL utilizando o script SQL disponível neste README.

### 4. Configure as credenciais

Na raiz do projeto, crie um arquivo chamado `db.properties` com base no arquivo `db.example.properties`.

```properties
user=SEU_USUARIO
password=SUA_SENHA
dburl=jdbc:mysql://localhost:3306/crud_jdbc
useSSL=false
```

### 5. Configure o MySQL Connector

Adicione o arquivo JAR do MySQL Connector/J ao Java Build Path do projeto, caso ainda não esteja configurado.

### 6. Execute a aplicação

Execute a classe principal `Program.java` para testar as operações do CRUD.

## 🔒 Segurança

O arquivo `db.properties` não é versionado no GitHub, pois contém informações sensíveis de conexão com o banco de dados.

Foi disponibilizado um arquivo `db.example.properties` como modelo de configuração, permitindo que outros desenvolvedores utilizem suas próprias credenciais.

## 🎯 Objetivo de Aprendizado

Este projeto faz parte da minha jornada de estudos em desenvolvimento backend.

Após concluir os estudos de JDBC e implementar este exercício, o próximo passo é aprofundar os conhecimentos em persistência de dados utilizando JPA e Hibernate, avançando posteriormente para o desenvolvimento de aplicações e APIs REST com Spring Boot.

## 👨‍💻 Autor

**Kelvin Eduardo Barbosa da Silva**

Estudante de Tecnologia da Informação e desenvolvimento backend, com foco na construção de aplicações, integração com bancos de dados e boas práticas de programação.

[![GitHub](https://img.shields.io/badge/GitHub-kelvineduardosilva-181717?style=for-the-badge&logo=github)](https://github.com/kelvineduardosilva)

---

⭐ Projeto desenvolvido para fins de estudo e aprimoramento dos conhecimentos em JDBC.
