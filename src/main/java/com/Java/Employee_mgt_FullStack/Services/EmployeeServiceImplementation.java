package com.Java.Employee_mgt_FullStack.Services;

import com.Java.Employee_mgt_FullStack.Model.Employee;
import com.Java.Employee_mgt_FullStack.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeesServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
   public List<Employee> getAllEmployees(){
   return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        Employee employeeToReturn = null;
        if (employee.isPresent()) {
            employeeToReturn = employee.get();
        }
        else{
            throw new RuntimeException("Employee not found with id: " + id);
        }
        return employeeToReturn;
    }

    @Override
    public void deleteEmployeeById(long id) {

        employeeRepository.deleteById(id);

    }


}
