/*criando uma view */
CREATE VIEW vFuncionarios as
select first_name,last_name,department_name  
from employees1 E inner join departments1 D ON
    E.DEPARTMENT_ID = D.DEPARTMENT_ID;

/*consultando a view*/
select * from vFuncionarios;

/*Criando uma view que mostre o nome sobrenome e funcao dos funcionarios que trabalham no departamento 40,50,60,70*/
create view vFuncionariosDep40506070 as
select first_name, last_name,job_id
from EMPLOYEES1
where DEPARTMENT_ID in (40,50,60,70);
--Consultando
select * from vFuncionariosDep40506070;
--criando a mesma mas concatenando o nome
create view vFuncionariosDep40506070 as
select first_name || ' ' || last_name nome_completo,job_id
from EMPLOYEES1
where DEPARTMENT_ID in (40,50,60,70);

/*Os comandos a seguir simulam comandos DML sobre uma view simples. Utilizando o LiveSQL, vamos analisar o que acontece em cada um deles….*/

CREATE TABLE EMPLOYEES AS SELECT * FROM HR.EMPLOYEES;

CREATE OR REPLACE VIEW emp_dep AS
  SELECT employee_id,Last_name,salary
  FROM employees;

SELECT * FROM EMP_DEP;

DELETE EMP_DEP
WHERE EMPLOYEE_ID = 108;

UPDATE EMP_DEP
SET SALARY = SALARY*1.2
WHERE EMPLOYEE_ID = 101;

INSERT INTO EMP_DEP
