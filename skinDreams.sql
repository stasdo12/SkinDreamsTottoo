DROP DATABASE IF EXISTS skin_dreams;

CREATE DATABASE skin_dreams;

\C DATABASE skin_dreams;


DROP TABLE IF EXISTS clients;
CREATE TABLE IF NOT EXISTS clients
(
    id                int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name              VARCHAR(255) not null,
    phone             VARCHAR(255) not null,
    email             VARCHAR(255),
    registration_time TIMESTAMP,
    question varchar(255)
);


DROP TABLE IF EXISTS masters;
CREATE TABLE IF NOT EXISTS masters
(
    id             int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name           VARCHAR(255) not null,
    specialization VARCHAR(255) not null,
    social_media VARCHAR(255) not null unique
);

DROP TABLE IF EXISTS review ;
CREATE TABLE IF NOT EXISTS review
(
    id             int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    author_name VARCHAR(255) not null,
    text TEXT not null,
    rating INTEGER not null,
    registration_time TIMESTAMP,
    master_id BIGINT REFERENCES masters(id)
);


DROP TABLE IF EXISTS traveling_masters ;
CREATE TABLE IF NOT EXISTS traveling_masters
(
    id             int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(255) not null,
    social_media VARCHAR(255) not null ,
    phone VARCHAR(255) not null,
    email VARCHAR(255) not null unique ,
    description VARCHAR(255)
);

DROP TABLE IF EXISTS traveling_master_desired_dates ;
CREATE TABLE IF NOT EXISTS traveling_master_desired_dates
(
    traveling_master_id BIGINT,
    desired_date DATE,
    FOREIGN KEY (traveling_master_id) REFERENCES traveling_masters(id)
);



DROP TABLE IF EXISTS blog ;
CREATE TABLE IF NOT EXISTS blog
(
    id  int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    title varchar(228) not null,
    text TEXT not null,
    registration_time TIMESTAMP

);






