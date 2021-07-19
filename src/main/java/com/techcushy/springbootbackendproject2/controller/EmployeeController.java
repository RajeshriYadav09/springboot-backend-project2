package com.techcushy.springbootbackendproject2.controller;

import com.techcushy.springbootbackendproject2.model.Employee;
import com.techcushy.springbootbackendproject2.service.impl.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        super();
        this.employeeService =employeeService;
    }

    //build create employee RestAPI
    //ResponseEntity<Employee> -> class,we can provide the complete response details,status, header
    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody  Employee employee){
         return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);

    }

    //build to get all employee list
    @GetMapping("/get/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //build get employee by Id
    //http://localhost:8080/api/employee/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmplyeeById(@PathVariable("id") long employeeId){
         return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }

    //build update employee rest api
    @PutMapping("{id}")
     public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee){

        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }

    //build delete employee restAPI
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
      employeeService.deleteEmployee(id);
      return new ResponseEntity<String>("Employee deleted successfully!!",HttpStatus.OK);
    }
}
