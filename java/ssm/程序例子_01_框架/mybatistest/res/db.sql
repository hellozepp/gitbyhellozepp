create database emptest;

use emptest;

create table t_emp(
	empno int auto_increment primary key,
	ename varchar(20),
	job varchar(10),
	mgr int,
	hiredate date,
	sal double,
	comm double,
	deptno int
);

Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (1,'SMITH','CLERK',3,'1980-5-12',800,null,20);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (2,'ALLEN','SALESMAN',3,'1981-6-3',1600,300,30);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (3,'WARD','SALESMAN',4,'1990-3-15',1250,500,30);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (4,'JONES','MANAGER',5,'1985-4-8',2975,null,20);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (5,'MARTIN','SALESMAN',7,'1986-3-8',1250,1400,30);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (6,'BLAKE','MANAGER',9,'1989-6-1',2850,null,30);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (7,'CLARK','MANAGER',9,'1995-10-1',2450,null,10);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (8,'SCOTT','ANALYST',9,'1993-5-1',3000,null,20);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (9,'KING','PRESIDENT',null,'1988-8-8',5000,null,10);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (10,'TURNER','SALESMAN',5,'1983-2-1',1500,0,30);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (11,'ADAMS','CLERK',5,'1992-7-3',1100,null,20);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (12,'JAMES','CLERK',1,'1996-9-10',950,null,30);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (13,'FORD','ANALYST',1,'1993-1-1',3000,null,20);
Insert into t_emp (EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values (14,'MILLER','CLERK',3,'1983-10-9',1300,null,10);


create table t_dept(
  deptno int primary key,
  dname varchar(20),
  loc varchar(50)
);

insert into t_dept values (10,'testing','beijing');
insert into t_dept values (20,'saling','shanghai');