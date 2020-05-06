/*
CRIAR O BANCO DE DADOS NO JAVA DB 
NOME: MUCHACHOS
USUARIO: MUCHACHOS
SENHA: MUCHACHOS
*/

--==============================================================================
--TABELA DE PTODUTO
--==============================================================================
CREATE TABLE TB_PRODUTO (
ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NOME VARCHAR(50),
CATEGORIA VARCHAR(30),
QUANTIDADE INT,
PRECO DECIMAL(8,2),
STATUS VARCHAR(10),
DESCRICAO VARCHAR(1000),
PRIMARY KEY (ID)
);
--==============================================================================
--TABELA DE CLIENTE
--==============================================================================
CREATE TABLE TB_CLIENTE (
ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NOME VARCHAR(50),
SEXO VARCHAR(10),
NASCIMENTO VARCHAR(20),
ESTADO_CIVIL VARCHAR(20),
STATUS VARCHAR(10),
RG VARCHAR(20),
CPF VARCHAR(20),
EMAIL VARCHAR(50),
TELEFONE VARCHAR(20),
ESTADO VARCHAR(20),
CIDADE VARCHAR(20),
BAIRRO VARCHAR(50),
CEP VARCHAR(20),
LOGRADOURO VARCHAR(50),
NUMERO INT,
COMPLEMENTO VARCHAR(20),
PRIMARY KEY (ID)
);
--==============================================================================
--TABELA DE COLABORADOR
--==============================================================================
CREATE TABLE TB_COLABORADOR (
ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NOME VARCHAR(50) NOT NULL,
SEXO VARCHAR(10),
NASCIMENTO VARCHAR(20) NOT NULL,
ESTADO_CIVIL VARCHAR(20) NOT NULL,
STATUS VARCHAR(10),
RG VARCHAR(20),
CPF VARCHAR(20) NOT NULL,
TELEFONE VARCHAR(20) NOT NULL,
EMAIL VARCHAR(50) NOT NULL,
SENHA VARCHAR(50) NOT NULL,
FILIAL VARCHAR(50),
DEPARTAMENTO VARCHAR(50),
CARGO VARCHAR(50),
ESTADO VARCHAR(20) NOT NULL,
CIDADE VARCHAR(20) NOT NULL,
BAIRRO VARCHAR(50),
LOGRADOURO VARCHAR(50) NOT NULL,
NUMERO INT NOT NULL,
COMPLEMENTO VARCHAR(20),
PRIMARY KEY(ID)
);
--==============================================================================
--TABELA DE VENDA
--==============================================================================
CREATE TABLE TB_VENDA (
ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
DATA TIMESTAMP,
QTD_ITENS INT,
VAL_TOTAL DECIMAL(8,2),
PAG_DINHEIRO DECIMAL(8,2),
PAG_DEBITO DECIMAL(8,2),
PAG_CREDITO DECIMAL(8,2),
PARCELAS VARCHAR(10),
VAL_DESCONTO DECIMAL(8,2),
VAL_TROCO DECIMAL(8,2)
);
--==============================================================================
--TABELA DE ITENSVENDA
--==============================================================================
CREATE TABLE TB_ITENSVENDA (
ID_VENDA INT,
ID_ITEM INT,
NOME_PRODUTO VARCHAR(50),
ID_PRODUTO INT,
QTD_ITENS INT,
VAL_UNITARIO DECIMAL(8,2),
VAL_TOTAL DECIMAL(8,2)
);
