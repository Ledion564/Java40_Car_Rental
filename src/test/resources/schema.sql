CREATE TABLE  IF NOT EXISTS Cars
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(50) ,
    brand VARCHAR(50),
    body_type VARCHAR(255),
    manufacture_year TIMESTAMP,
    colour VARCHAR(50),
    mileage VARCHAR(50),
    status VARCHAR (50),
    amount VARCHAR(50),
    created_by VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS categories (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    category_type VARCHAR(255) NOT NULL,
    priority INT,
    rating DOUBLE,
    created_by VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE,
    code VARCHAR(255) NOT NULL UNIQUE
    );

CREATE TABLE IF NOT EXISTS Reviews(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    created_by VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Users(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL ,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    is_active BOOLEAN
);

CREATE TABLE IF NOT EXISTS revenues(
    id LONG AUTO_INCREMENT PRIMARY KEY,
    total_amount DOUBLE,
    approved_amount DOUBLE,
    unapproved_amount DOUBLE

);

CREATE TABLE IF NOT EXISTS revenues(
    id LONG AUTO_INCREMENT PRIMARY KEY,
    total_amount DOUBLE,
    approved_amount DOUBLE,
    unapproved_amount DOUBLE

);