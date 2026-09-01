1 feita
DECLARE 
V_ANO NUMBER (4);
BEGIN 
    DBMS_OUTPUT.PUT_LINE('OS SEGUINTES ANOS SÃO BISSEXTOS:');
        FOR V_ANO IN 2000..2100 LOOP
            IF (MOD(V_ANO,4) = 0 AND MOD (V_ANO,100)!=0) OR (MOD(V_ANO,400)=0 )THEN
                DBMS_OUTPUT.PUT_LINE(V_ANO);
            END IF;
        END LOOP;
END;
/
DECLARE
    V_A NUMBER(2) :=1;
    V_B NUMBER(2) :=1;
    V_C NUMBER(2) :=0;
BEGIN
    FOR V_I IN 1..11 LOOP
        V_A :=V_B;
        V_B := V_C;
        DBMS_OUTPUT.PUT_LINE(V_C);
        V_C := V_A + V_B;
    END LOOP;
END;
/

--EXEMPLO 5
DECLARE
    lv_var varchar2(15);
BEGIN
    lv_var := 'Hello world!';
    DBMS_OUTPUT.PUT_LINE(sysdate +lv_var);
exception
    when others then
        dbms_output.put_line('ERRO!!!!');
end;
/
--Exemplo 6
CREATE TABLE PRODUTO (
CODIGO NUMBER(4),
CATEGORIA CHAR(1),
VALOR NUMBER(4,2));

INSERT INTO PRODUTO VALUES (1001,'A',7.55);
INSERT INTO PRODUTO VALUES (1002,'B',5.95);
INSERT INTO PRODUTO VALUES (1003,'C',3.45);

--Solução 1

declare 
cursor curProduto is SELECT * from produto;
recProduto curProduto%ROWTYPE;
begin
        for recProduto in curProduto LOOP  
            if recProduto.categoria = 'A'   then
                update PRODUTO SET VALOR = VALOR * 1.05 WHERE CODIGO = recProduto.codigo;
            elsif recProduto.categoria = 'B' THEN
                update PRODUTO SET VALOR = VALOR*1.10 WHERE CODIGO = recProduto.CODIGO;
            else
                update PRODUTO SET VALOR = valor*1.15 where codigo = recProduto.codigo;
            end if;
        end loop;
    end;

--SOLUCAO 2
DECLARE 
    CURSOR C_PRODUTO IS SELECT * FROM PRODUTO;
    V_PRODUTO PRODUTO%ROWTYPE;
    V_REAJUSTE NUMBER(3,2);
BEGIN
    FOR V_PRODUTO IN C_PRODUTO LOOP
        IF V_PRODUTO.CATEGORIA = 'A' THEN
            V_REAJUSTE := 1.05;
        ELSIF V_PRODUTO.CATEGORIA = 'B' THEN
            V_REAJUSTE :=1.10;
        ELSE
            V_REAJUSTE :=1.15;
        END IF;
    
    UPDATE PRODUTO SET VALOR = VALOR * V_REAJUSTE WHERE CODIGO = V_PRODUTO.CODIGO;
    END LOOP;
END;
/

2A consulta abaixo retorna um numero aleatorio. criar um bloco anonimo plsql que a partir do resultado desta consulta imprima uma mensagem informando se o numero é igual a zero ou se é maior ou menor do que zero --SELECT DBMS_RANDOM.NORMAL FROM DUAL;.
DECLARE
   v_numero NUMBER;     -- caixinha pra guardar o número aleatório
BEGIN
   -- Pega o número aleatório e guarda na caixinha
   SELECT DBMS_RANDOM.NORMAL 
     INTO v_numero 
   FROM DUAL;

   -- Agora faz a comparação
   IF v_numero = 0 THEN
      DBMS_OUTPUT.PUT_LINE('O número é IGUAL a zero');
   
   ELSIF v_numero > 0 THEN
      DBMS_OUTPUT.PUT_LINE('O número é MAIOR que zero');
   
   ELSE
      DBMS_OUTPUT.PUT_LINE('O número é MENOR que zero');
   END IF;

END;
/

--Aumente o salario de todo mundo em 9% da tabela employees
DECLARE    
cursor curSalario is select employee_id from EMPLOYESS;
begin 
    for recSalario in curSalario loop
        update employess set salary = salary*1.09 where employee_id = recSalario.employee_id;
    end loop;
end;
/
select salary from employess where employee_id = 100;


-- conta todos os funcionarios de cada departamento
Declare 
cursor curE is select job_id,count(*) as quanti from employess group by job_id;
begin
    for recF in curE loop
        dbms_output.put_line('Funcionarios que trabalham no '||recF.job_id || ' = '||recF.quanti);
    end loop;
end;
/
--Utilizando uma variável do tipo cursor, criar um bloco anônimo PL/SQL que seja capaz de imprimir o nome, o sobrenome, e-mail e --a data de contratação dos funcionários. Listar o resultado por ordem alfabética de nome e sobrenome. O resultado deve ser igual -- o seguinte:

declare 
Cursor CurFunc is select first_name ||' ' || last_name as FullName,email,hire_date from EMPLOYESS order by FullName ASC;
BEGIN
    for FuncRec in CurFunc loop
        dbms_output.put_line(FuncRec.FullName || ' - ' || 'Email:'|| FuncRec.email || ' - '|| 'Data de contratação' || FuncRec.hire_date);
    end loop;
END;
/