CREATE DATABASE IF NOT EXISTS m4_jpa_c0525l1;
USE m4_jpa_c0525l1;

CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price INT,
    category VARCHAR(255),
    description VARCHAR(255)
);