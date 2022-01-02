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

create or replace table quarter_results(
  code varchar(5)
  , name NVARCHAR(100)
  , standards NVARCHAR(10)
  , result_type NVARCHAR(10)
  , term NVARCHAR(10)
  , quarter NVARCHAR(10)
  , start_date date
  , end_date date
  , title NVARCHAR(10)
  , sales bigint
  , operation_income bigint
  , ordinary_income bigint
  , net_income bigint
  , eps Decimal (10, 2)
  , PRIMARY KEY(code, term, quarter)
);

create table quarter_results_tmp (
  code varchar(5)
  , name NVARCHAR(100)
  , standards NVARCHAR(10)
  , result_type NVARCHAR(10)
  , term NVARCHAR(10)
  , quarter NVARCHAR(10)
  , start_date date
  , end_date date
  , title NVARCHAR(10)
  , sales bigint
  , operation_income bigint
  , ordinary_income bigint
  , net_income bigint
  , eps Decimal (10, 2)
  , deps Decimal (10, 2)
  , net_assets bigint
  , total_assets bigint
  , bps Decimal (10, 2)
  , ocf bigint
  , icf bigint
  , fcf bigint
  , update_date date
);

insert
into quarter_results
(
    code
    ,name
    ,standards
    ,result_type
    ,term
    ,quarter
    ,start_date
    ,end_date
    ,title
    ,sales
    ,operation_income
    ,ordinary_income
    ,net_income
    ,eps
)
select
    qrt.code
    , qrt.name
    , qrt.standards
    , qrt.result_type
    , qrt.term
    , qrt.quarter
    , max(qrt.start_date)
    , max(qrt.end_date)
    , max(qrt.title)
    , max(qrt.sales)
    , max(qrt.operation_income)
    , max(qrt.ordinary_income)
    , max(qrt.net_income)
    , max(qrt.eps)
from
    quarter_results_tmp qrt
    inner join (
        select
            code
            , term
            , quarter
            , max(result_type) result_type
        from
            quarter_results_tmp
        group by
            code
            , term
            , quarter
    ) tmp
        on qrt.code = tmp.code
        and qrt.term = tmp.term
        and qrt.quarter = tmp.quarter
        and qrt.result_type = tmp.result_type
group by
    qrt.code
    , qrt.term
    , qrt.quarter;