--Explique o que é um trigger em um banco de dados relacional
Um trigger é um gatilho para uma ação que pode acontecer antes ou depois de um comando sql que usam uma linguagem de programação
--Explique o que são as variáveis NEW e OLD em um trigger.
As variaveis New e old são usadas para acessar os dados da tabelas antes ou de pois do comando 
New serve para acessar a nova informação que sera cadastrada no banco de dados
Old serve para acessar a informação antes da mudança do trigger

--Em que instrução(ções) DML a variável OLD pode ser utilizada?
A old pode ser usada em delet e update

--Em um trigger, além de ter acesso nativo às tabelas do banco de dados a partir das instruções DQL e DML, é possível utilizar outros recursos que são bastante comuns nas linguagens de programação. Quais recursos são estes? 
Podemos usar comando IF, else, for, while.

--4 

CREATE OR REPLACE TRIGGER THistoricoCompra
AFTER UPDATE ON produtos
FOR EACH ROW
BEGIN
    IF (:OLD.prd_valor <> :NEW.prd_valor) THEN
        INSERT INTO historico_precos
            (prd_codigo, data, prd_preco_antigo, prd_preco_novo, usuario_sistema)
        VALUES
            (:OLD.prd_codigo,
             SYSDATE,
             :OLD.prd_valor,
             :NEW.prd_valor,
             USER);
    END IF;
END;
