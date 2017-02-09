SELECT userinfo.u_money FROM userinfo WHERE userinfo.u_id=1;
SELECT employee.e_price FROM employee WHERE e_id=1;

SELECT user_employee.u_id FROM user_employee WHERE u_id=1;

UPDATE userinfo u SET u.u_money=500 WHERE u_id=1;
INSERT INTO user_employee(u_id,e_id,e_typied,e_duration,e_starteddate,e_enddate,e_egrade)
VALUES (2,2,'农医师',30,'2017-02-05','2017-03-04',1);
select * from user_employee;

