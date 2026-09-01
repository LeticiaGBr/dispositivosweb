--1No esquema Human Resources, criar uma view para listar todos os dados de funcionários e também o título de sua respectiva função. Apresente no resultado apenas os funcionários que ganham entre 5.000,00 e 7.000,00 e que sejam comissionados.

CREATE VIEW vFuncionarioSalario AS
SELECT 
    e.employee_id,
    e.first_name,
    e.last_name,
    e.email,
    e.phone_number,
    e.hire_date,
    j.job_title, -- Título da função
    e.salary,
    e.commission_pct
FROM 
    EMPLOYEES1 e
JOIN 
    jobs1 j ON e.job_id = j.job_id
WHERE 
    e.salary BETWEEN 5000 AND 7000
    AND e.commission_pct IS NOT NULL 
    AND e.commission_pct > 0;

--2 No esquema Human Resources, criar uma view para listar os nomes dos países e o nome da região em que se localizam.

create view PaizEregiao as 
select 
p.country_name,
r.region_name
from paizes p 
 join regiao r on 
p.REGION_ID = r.REGION_ID;


--3  No esquema Human Resources, criar uma view para listar os nomes de departamentos seguidos da cidade onde se localizam e o nome e telefone do gerente.

create view Gerentes as 
select 
f.FIRST_NAME,
f.PHONE_NUMBER,
d.DEPARTMENT_NAME,
l.city
from FUNCIONARIOS f 
inner join DEPARTAMENTO d on
f.DEPARTMENT_ID = d.DEPARTMENT_ID 
inner JOIN LOCALIDADES l on d.LOCATION_ID = l.LOCATION_ID;

--4 No esquema Human Resources, criar uma view para listar os nomes dos funcionários e o título da função de cada um deles.
create view FuncaoDeFuncionarios as
select 
f.First_name,
j.job_title from FUNCIONARIOS f inner join 
JOBS1 j on f.JOB_ID = j.job_id 

--5No esquema Human Resources, criar uma view para listar os nomes dos funcionários, a data de início e fim que cada um permaneceu em uma determinada função e a função (exibir o título da função).
CREATE OR REPLACE VIEW vw_funcionarios_historico_funcoes AS
SELECT 
    e.first_name || ' ' || e.last_name AS nome_funcionario,
    jh.start_date AS data_inicio,
    jh.end_date AS data_fim,
    j.job_title AS titulo_funcao
FROM hr.job_history jh
JOIN hr.employees e ON e.employee_id = jh.employee_id
JOIN hr.jobs j ON j.job_id = jh.job_id;

--6
CREATE OR REPLACE VIEW vw_funcionarios_salarios_gerentes AS
SELECT 
    e.first_name || ' ' || e.last_name AS nome_funcionario,
    e.salary,
    m.first_name || ' ' || m.last_name AS nome_gerente
FROM hr.employees e
LEFT JOIN hr.employees m ON e.manager_id = m.employee_id;

--7
CREATE OR REPLACE VIEW vw_funcionarios_departamentos_cidade AS
SELECT 
    e.first_name || ' ' || e.last_name AS nome_funcionario,
    d.department_name,
    l.city
FROM hr.employees e
JOIN hr.departments d ON e.department_id = d.department_id
JOIN hr.locations l ON d.location_id = l.location_id;

--8
CREATE OR REPLACE VIEW vw_funcionarios_cidades_especificas AS
SELECT 
    e.first_name || ' ' || e.last_name AS nome_funcionario,
    j.job_title,
    d.department_id,
    d.department_name
FROM hr.employees e
JOIN hr.jobs j ON e.job_id = j.job_id
JOIN hr.departments d ON e.department_id = d.department_id
JOIN hr.locations l ON d.location_id = l.location_id
WHERE l.city IN ('Tokyo', 'Roma', 'Oxford', 'Munich');

--9
CREATE OR REPLACE VIEW vw_funcionarios_gerentes_codigos AS
SELECT 
    e.first_name || ' ' || e.last_name AS "Funcionário",
    e.employee_id AS "Nr_funcionário",
    m.first_name || ' ' || m.last_name AS "Gerente",
    m.employee_id AS "Nr_gerente"
FROM hr.employees e
LEFT JOIN hr.employees m ON e.manager_id = m.employee_id;

-10
CREATE OR REPLACE VIEW vw_gerentes_departamentos_localizacao AS
SELECT DISTINCT
    m.first_name || ' ' || m.last_name AS nome_gerente,
    d.department_name,
    l.city
FROM hr.departments d
JOIN hr.employees m ON d.manager_id = m.employee_id
JOIN hr.locations l ON d.location_id = l.location_id;

--11
CREATE OR REPLACE VIEW vw_funcionarios_salario_maior_3850 AS
SELECT 
    e.first_name || ' ' || e.last_name AS nome_funcionario,
    j.job_title,
    e.salary
FROM hr.employees e
JOIN hr.jobs j ON e.job_id = j.job_id
WHERE e.salary > 3850;

--8
CREATE OR REPLACE VIEW vw_funcionarios_salario_fora_faixa AS
SELECT 
    e.first_name || ' ' || e.last_name AS nome_funcionario,
    e.salary
FROM hr.employees e
WHERE e.salary NOT BETWEEN 1500 AND 2850;

