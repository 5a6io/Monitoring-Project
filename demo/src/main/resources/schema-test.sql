-- 스키마 생성 --
create schema if not exists test;

-- 테이블 생성 --
create table if not exists test.users (
    id bigserial primary key,
    username varchar(5) not null,
    password varchar(255) not null,
    email varchar(20) not null,
    constraint idx_username unique (username),
    constraint idx_email unique (email)
);

create table if not exists test.questions (
    qid bigserial primary key,
    email varchar(20) not null,
    username varchar(5) not null,
    question varchar(255) not null,
    date timestamp default current_timestamp,
    constraint fk_username foreign key (username) references test.users (username) on update cascade on delete cascade,
    constraint fk_email foreign key (email) references test.users (email) on update cascade on delete cascade
);