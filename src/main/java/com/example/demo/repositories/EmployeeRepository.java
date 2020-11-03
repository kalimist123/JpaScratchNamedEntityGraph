package com.example.demo.repositories;
import java.util.List;

import com.example.demo.models.Customer;
import com.example.demo.models.Employee;
import com.example.demo.models.EmployeeId;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, EmployeeId>{


}
