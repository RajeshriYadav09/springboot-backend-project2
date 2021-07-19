package com.techcushy.springbootbackendproject2.service;

import com.techcushy.springbootbackendproject2.exception.ResourceNotFoundException;
import com.techcushy.springbootbackendproject2.model.Employee;
import com.techcushy.springbootbackendproject2.repository.EmployeeRepository;
import com.techcushy.springbootbackendproject2.service.impl.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
          this.employeeRepository =employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
       return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        // Normal approach
      /*Optional<Employee> employee =  employeeRepository.findById(id);
      if(employee.isPresent()){
          return employee.get();
      }else{
          throw new ResourceNotFoundException("Employee","Id",id);
      }*/
        //Lambda expression
        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee","Id",id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //we need to check where employee with given id is existing or not
       Employee existingEmployee =  employeeRepository.findById(id).orElseThrow(
               ()-> new ResourceNotFoundException("Employee","Id",id));
       existingEmployee.setFirstName(employee.getFirstName());
       existingEmployee.setLastName(employee.getLastName());
       existingEmployee.setEmail(employee.getEmail());

       employeeRepository.save(existingEmployee);
       return  existingEmployee;

    }

    @Override
    public void deleteEmployee(long id) {
        //check where employee exist in database or not
        employeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);
    }
}
