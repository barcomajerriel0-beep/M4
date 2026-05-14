CREATE DATABASE sports_academy;

USE sports_academy;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(50),
    role VARCHAR(30)
);

CREATE TABLE athletes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    sport VARCHAR(100)
);

CREATE TABLE training_sessions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    athlete_name VARCHAR(100),
    date VARCHAR(50),
    time VARCHAR(50),
    location VARCHAR(100),
    performance VARCHAR(255),
    attended BOOLEAN
);

CREATE TABLE payments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    payment_method VARCHAR(50),
    subtotal DOUBLE,
    discount DOUBLE,
    tax DOUBLE,
    total DOUBLE
);

SELECT * FROM users;

SELECT * FROM athletes; 

SELECT * FROM training_sessions;

SELECT * FROM payments;