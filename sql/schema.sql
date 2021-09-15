create table employee (
  emp_id varchar(3),
  emp_name nvarchar(50) not null,
  job_cd varchar(3) not null,
  dept_id varchar(2) not null,
  hire_date date not null,
  retire_date date, 
  primary key (`emp_id`)
);

create table department (
  dep_id varchar(2),
  dep_name nvarchar(20) not null,
  primary key (`dep_id`)
);

create table job (
  job_cd varchar(2),
  job_name nvarchar(10) not null,
  primary key (`job_cd`)
);
