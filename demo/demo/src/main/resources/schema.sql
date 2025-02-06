-- 스키마 생성 --
create schema if not exists test authorization ${{ secrets.POSTGRES_USER }};

-- 테이블 생성 --
create table if not exists public.users (
    id bigint generated always as identity,
    username varchar(5) not null,
    password varchar(15) not null,
    email varchar(20) not null,
    constraint users_pk primary key (username)
);

create table if not exists public.questions (
    q_id generated always as identity,
    email varchar(20) not null,
    username varchar(5) not null,
    question varchar(255) not null,

    constraint list_pk primary(list_id)
);