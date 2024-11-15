package com.Java.Employee_mgt_FullStack.Services;

import com.Java.Employee_mgt_FullStack.Model.Employee;

import java.util.List;

public interface EmployeesServices {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
}
