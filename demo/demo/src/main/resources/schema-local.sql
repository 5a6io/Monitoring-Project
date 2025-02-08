-- 스키마 생성 --
create schema if not exists test;

-- 테이블 생성 --
create table if not exists test.users (
    id bigint auto_increment primary key,
    username varchar(5) not null,
    password varchar(255) not null,
    email varchar(20) not null,
    index idx_username (username),
    index idx_email (email)
);

create table if not exists test.questions (
    qid bigint auto_increment primary key,
    email varchar(20) not null,
    username varchar(5) not null,
    question varchar(255) not null,
    date datetime default current_timestamp(),
    foreign key (username) references test.users (username) on update cascade on delete cascade,
    foreign key (email) references test.users (email) on update cascade on delete cascade
);