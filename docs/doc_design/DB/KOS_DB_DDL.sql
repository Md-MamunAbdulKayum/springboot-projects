-- FileName: KOS_DB_DDL.sql
-- Description: script to create TABLEs, VIEWs in KOS_DB database
-- Version: 1.0
-- Author: Mamun Kayum
-- Last Modified: 15 April 2022


-- Create the database
CREATE DATABASE IF NOT EXISTS KOS_DB;

-- use KOS_DB database
USE KOS_DB;

-- SQL statements to drop all the tables and views from the KOS_DB database

DROP TABLE IF EXISTS order_details;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_category;
DROP TABLE IF EXISTS manufacturer;
DROP TABLE IF EXISTS order_t;
DROP TABLE IF EXISTS shipper;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS employee_role;


-- create tables

-- SQL statement to create employee_role table
CREATE TABLE employee_role(
	emp_role_id int NOT NULL AUTO_INCREMENT,
    emp_role_title varchar(30) NOT NULL,
	PRIMARY KEY (emp_role_id)
);

-- SQL statement to create employee table
CREATE TABLE employee (
	emp_id int NOT NULL AUTO_INCREMENT,
    emp_role_id int(30) NOT NULL,
	first_name varchar(255) NOT NULL,
	last_name varchar(255) NOT NULL,
	job_title varchar(255) NOT NULL,
	address varchar(255) NOT NULL,
	date_of_birth DATE NOT NULL,
	hire_date DATE NOT NULL,
	PRIMARY KEY (emp_id),
	FOREIGN KEY (emp_role_id) REFERENCES employee_role(emp_role_id)
);