create table tbl_bird
(
    id     NUMBER
        constraint pk_bird
            primary key,
    name   varchar2(100),
    age    number,
    gender varchar2(100)
);

create sequence seq_bird
    start with 1
    increment by 1
    nocache;

SELECT SEQ_BIRD.nextval FROM DUAL;

SELECT * FROM TBL_BIRD
WHERE ID = 1;

























