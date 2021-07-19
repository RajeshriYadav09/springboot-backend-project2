package com.techcushy.springbootbackendproject2.repository;

import com.techcushy.springbootbackendproject2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<Employee,Long>{
}
