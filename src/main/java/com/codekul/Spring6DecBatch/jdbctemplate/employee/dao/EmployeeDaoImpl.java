package com.codekul.Spring6DecBatch.jdbctemplate.employee.dao;

import com.codekul.Spring6DecBatch.jdbctemplate.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    String insertQuery = "Insert into employee(name,location,department) values(?,?,?)";
    String findAll = "select * from employee";
    String findById = "select * from employee where id=?";
    String findByName = "Select * from employee where name =?";
    String findByNameAndDepartment = "Select * from employee where name =? and  department = ?";
    String deleteById = "delete from employee where id=?";
    String updateRecords = "update employee set name=?, location=?,department=? where id=?";
    @Override
    public String save(Employee e) {
        Object fields [] = new Object[]{e.getName(),e.getLocation(),e.getDepartment()};
        jdbcTemplate.update(insertQuery,fields);
        return "Data saved successfully";
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query(findAll,new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public Employee findById(Long id) {
        return jdbcTemplate.queryForObject(findById,new BeanPropertyRowMapper<>(Employee.class),id);
    }

    @Override
    public List<Employee> findByName(String name,String department) {
        if (department !=null)
            return jdbcTemplate.query(findByNameAndDepartment,new BeanPropertyRowMapper<>(Employee.class),name,department);
        return jdbcTemplate.query(findByName,new BeanPropertyRowMapper<>(Employee.class),name);
    }


    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(deleteById,id);
    }

    @Override
    public int update(Long id, Employee e) {
        return jdbcTemplate.update(updateRecords,new Object[]{e.getName(),e.getLocation(),e.getDepartment(),id});
    }

}
