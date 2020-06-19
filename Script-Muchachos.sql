/*
CRIAR O BANCO DE DADOS NO JAVA DB 
NOME: BD_MUCHACHOS
USUARIO: MUCHACHOS
SENHA: MUCHACHOS
*/

--==============================================================================
--TABELA DE PRODUTO
--==============================================================================
CREATE TABLE TB_PRODUTO (
ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NOME VARCHAR(50),
PRECO DECIMAL(8,2),
QUANTIDADE INT,
DESCRICAO VARCHAR(1000),
CATEGORIA VARCHAR(30),
STATUS VARCHAR(10),
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
CIDADE VARCHAR(50),
BAIRRO VARCHAR(50),
CEP VARCHAR(20),
LOGRADOURO VARCHAR(60),
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
CIDADE VARCHAR(50) NOT NULL,
BAIRRO VARCHAR(50),
LOGRADOURO VARCHAR(50) NOT NULL,
NUMERO INT NOT NULL,
COMPLEMENTO VARCHAR(30),
PRIMARY KEY(ID)
);
--==============================================================================
--TABELA DE VENDA
--==============================================================================
CREATE TABLE TB_VENDA (
ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
ID_CLIENTE INT,
ID_FUNCIONARIO INT,
DATA TIMESTAMP,
QTD_ITENS INT,
VAL_TOTAL DECIMAL(8,2),
PAG_DINHEIRO DECIMAL(8,2),
PAG_DEBITO DECIMAL(8,2),
PAG_CREDITO DECIMAL(8,2),
PARCELAS VARCHAR(10),
VAL_DESCONTO DECIMAL(8,2),
VAL_TROCO DECIMAL(8,2),
PRIMARY KEY(ID)
);
--==============================================================================
--TABELA DE ITENSVENDA
--==============================================================================
CREATE TABLE TB_ITENSVENDA (
ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
ID_VENDA INT,
ID_PRODUTO INT,
QTD_ITENS INT,
VAL_TOTAL DECIMAL(8,2),
PRIMARY KEY(ID)
);
--==============================================================================
--INSERE USUARIO ADMIN
--==============================================================================
INSERT INTO TB_COLABORADOR (NOME, NASCIMENTO, ESTADO_CIVIL, STATUS, CPF, TELEFONE, EMAIL, SENHA, FILIAL, ESTADO, CIDADE, LOGRADOURO, NUMERO)
VALUES ('Administrador', '1900-01-01', 'Solteiro', 'Ativo', '000.000.000-00', '00000000000', 'admin@muchachos', 'admin', 'Acre', 'Sao Paulo', 'Sao Paulo', 'Rua Admin', 0)
--==============================================================================
--TRIGGER ATUALIA ESTOQUE
--==============================================================================
CREATE TRIGGER ATUALIZA_ESTOQUE
AFTER INSERT ON TB_ITENSVENDA
REFERENCING NEW AS LINHA_INSERIDA
FOR EACH ROW MODE DB2SQL
UPDATE TB_PRODUTO
SET QUANTIDADE = (SELECT QUANTIDADE FROM TB_PRODUTO WHERE ID = LINHA_INSERIDA.ID_PRODUTO) - LINHA_INSERIDA.QTD_ITENS
WHERE ID = LINHA_INSERIDA.ID_PRODUTO