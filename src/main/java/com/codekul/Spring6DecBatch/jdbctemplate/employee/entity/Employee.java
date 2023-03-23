package com.codekul.Spring6DecBatch.jdbctemplate.employee.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private Long id;
    private String name;
    private String location;
    private String department;
}
/**
 * create database springbootjdbc;
 * use testdb;
 *
 * create table employee(
 * id INT primary key auto_increment,
 * name varchar(30) not null,location varchar(50)not null,department varchar(30)not null);
 *
 * insert into employee(name,location,department) values('Akshay','Pune','Sale');
 * insert into employee(name,location,department) values('Namita','Mumbai','Finanace');
 * select * from employee;
 */