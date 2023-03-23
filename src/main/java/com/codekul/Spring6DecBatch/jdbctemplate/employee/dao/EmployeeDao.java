package com.codekul.Spring6DecBatch.jdbctemplate.employee.dao;


import com.codekul.Spring6DecBatch.jdbctemplate.employee.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    String save(Employee e);

    List<Employee> findAll();

    Employee findById(Long id);

    List<Employee>  findByName(String name,String department);

    void deleteById(Long id);

    int update(Long id,Employee e);

}
