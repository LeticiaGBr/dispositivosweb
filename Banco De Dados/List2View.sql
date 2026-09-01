-- 1
CREATE OR REPLACE VIEW v_produto_mais_caro_subcategoria AS
SELECT prod_subcategory,
       MAX(prod_list_price) AS preco_mais_caro
FROM sh.products
GROUP BY prod_subcategory;


-- 2
CREATE OR REPLACE VIEW v_clientes_acima_media_1998 AS
SELECT c.cust_first_name || ' ' || c.cust_last_name AS nome_cliente,
       AVG(s.amount_sold) AS valor_medio_compras
FROM sh.customers c
JOIN sh.sales s ON c.cust_id = s.cust_id
JOIN sh.times t ON s.time_id = t.time_id
WHERE t.time_id BETWEEN DATE '1998-01-01' AND DATE '1998-12-31'
GROUP BY c.cust_first_name, c.cust_last_name
HAVING AVG(s.amount_sold) >
      (SELECT AVG(amount_sold)
       FROM sh.sales s2
       JOIN sh.times t2 ON s2.time_id = t2.time_id
       WHERE t2.time_id BETWEEN DATE '1998-01-01' AND DATE '1998-12-31');


-- 3
CREATE OR REPLACE VIEW v_emp_dept_salario_total AS
SELECT e.ename,
       e.job,
       d.dname,
       (e.sal + NVL(e.comm,0)) AS "Salário total"
FROM scott.emp e
JOIN scott.dept d ON e.deptno = d.deptno
WHERE d.loc IN ('DALLAS','CHICAGO');


-- 4
CREATE OR REPLACE VIEW v_func_salario_dept_10_30 AS
SELECT first_name || ' ' || last_name AS "Funcionário",
       salary AS "Salário Mensal"
FROM hr.employees
WHERE salary > 1500
AND department_id IN (10,30);


-- 5
CREATE OR REPLACE VIEW v_func_sem_gerente AS
SELECT first_name || ' ' || last_name AS nome,
       job_id
FROM hr.employees
WHERE manager_id IS NULL;


-- 6
CREATE OR REPLACE VIEW v_func_comissao AS
SELECT first_name || ' ' || last_name AS nome,
       salary,
       NVL(TO_CHAR(commission_pct),'não comissionado') AS comissao
FROM hr.employees;


-- 7
CREATE OR REPLACE VIEW v_func_dois_s AS
SELECT first_name || ' ' || last_name AS nome
FROM hr.employees
WHERE (UPPER(first_name || last_name) LIKE '%S%S%'
AND department_id = 30)
OR manager_id = 103;


-- 8
CREATE OR REPLACE VIEW v_func_jobs_especificos AS
SELECT first_name || ' ' || last_name AS nome,
       job_id,
       salary
FROM hr.employees
WHERE job_id IN ('IT_PROG','MK_MAN','MK_REP')
AND salary NOT IN (1000,3000,5000);


-- 9
CREATE OR REPLACE VIEW v_departamentos_soma_salarios AS
SELECT d.department_name,
       SUM(e.salary) AS soma_salarios
FROM hr.departments d
JOIN hr.employees e ON d.department_id = e.department_id
GROUP BY d.department_name
HAVING SUM(e.salary) > 5000;


-- 10
CREATE OR REPLACE VIEW v_maior_salario_por_funcao AS
SELECT j.job_title,
       MAX(e.salary) AS "Mais alto por função"
FROM hr.jobs j
JOIN hr.employees e ON j.job_id = e.job_id
GROUP BY j.job_title
HAVING MAX(e.salary) <= 10000;


-- 11
CREATE OR REPLACE VIEW v_media_salario_manager AS
SELECT j.job_title,
       AVG(e.salary) AS "Média de salário por função"
FROM hr.jobs j
JOIN hr.employees e ON j.job_id = e.job_id
WHERE j.job_title LIKE '%Manager%'
GROUP BY j.job_title;


-- 12
CREATE OR REPLACE VIEW v_media_salario_manager_intervalo AS
SELECT j.job_title,
       AVG(e.salary) AS "Média de salário por função"
FROM hr.jobs j
JOIN hr.employees e ON j.job_id = e.job_id
WHERE j.job_title LIKE '%Manager%'
GROUP BY j.job_title
HAVING AVG(e.salary) BETWEEN 10500 AND 12500;


-- 13
CREATE OR REPLACE VIEW v_departamentos_com_gerentes AS
SELECT d.department_name,
       COUNT(*) AS quantidade_gerentes
FROM hr.departments d
JOIN hr.employees e ON d.department_id = e.department_id
JOIN hr.jobs j ON e.job_id = j.job_id
WHERE j.job_title LIKE '%Manager%'
GROUP BY d.department_name
HAVING COUNT(*) > 1;