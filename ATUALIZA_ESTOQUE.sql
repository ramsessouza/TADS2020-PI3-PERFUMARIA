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