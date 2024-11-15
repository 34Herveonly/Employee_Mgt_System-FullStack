package com.Java.Employee_mgt_FullStack.Repository;

import com.Java.Employee_mgt_FullStack.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
