package com.codekul.Spring6DecBatch.jdbctemplate.employee.controller;

import com.codekul.Spring6DecBatch.jdbctemplate.employee.dao.EmployeeDao;
import com.codekul.Spring6DecBatch.jdbctemplate.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {


    @Autowired
    private EmployeeDao employeeDao;

    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee){
       String msg = employeeDao.save(employee);
       return msg;
    }

    @GetMapping("/findAll")
    public List<Employee> getAllEmployee(){
        return employeeDao.findAll();
    }

    @GetMapping("/findById/{userId}")
    public Employee findById(@PathVariable("userId") Long userId1){ // when any data wants to get using any id then use
                                                                       //@path-variable
        return employeeDao.findById(userId1);
    }

    @GetMapping("/findByName")
    public  List<Employee>  findByName(@RequestParam String name, // when the data is in the form of key and value
                                                                  // @RequestParam
                               @RequestParam(required = false) String department){
        return employeeDao.findByName(name,department);
        // http://localhost:8081/emp/findByName?name=Ankita&department=Account&id=1
    }

    @PutMapping("/updateEmployee/{empId}")
    public String update(@RequestBody Employee employee,@PathVariable Long empId){
        employeeDao.update(empId,employee);
        return "Record updated successfully"; //@RequestBody maps the HttpRequest body to a transfer or domain object,
    }                                          // when we want to update at that time use @RequestBody


    @DeleteMapping("/delete/{empId}")
    public String delete(@PathVariable Long empId){
        employeeDao.deleteById(empId);
        return "Record deleted successfully";
    }
}

