-- 스키마 생성 --
CREATE SCHEMA IF NOT EXISTS test;

-- 테이블 생성 --
CREATE TABLE IF NOT EXISTS test.users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(5) NOT NULL,
    password VARCHAR(15) NOT NULL,
    email VARCHAR(20) NOT NULL,
    CONSTRAINT idx_username UNIQUE (username),
    CONSTRAINT idx_email UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS test.questions (
    q_id BIGSERIAL PRIMARY KEY,
    email VARCHAR(20) NOT NULL,
    username VARCHAR(5) NOT NULL,
    question VARCHAR(255) NOT NULL,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES test.users (username) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_email FOREIGN KEY (email) REFERENCES test.users (email) ON UPDATE CASCADE ON DELETE CASCADE
);