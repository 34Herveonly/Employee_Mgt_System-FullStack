package com.Java.Employee_mgt_FullStack.Controller;

import com.Java.Employee_mgt_FullStack.Model.Employee;
import com.Java.Employee_mgt_FullStack.Services.EmployeesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeesServices employeesServices;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("ListEmployees", employeesServices.getAllEmployees());
        return "Home";
    }

    @GetMapping("/showNewEmployeeFrom")
    public String showNewEmployeeFrom(Model model){
        Employee newEmployee = new Employee();
        model.addAttribute("newEmployee", newEmployee);
        return "NewEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee){
        employeesServices.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/showFormForUpdate/{id}")
    public String editSelectedEmployee(@PathVariable("id") long id, Model model){
        Employee employee=employeesServices.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "UpdateEmployee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        // Update the employee record in the database
        employeesServices.saveEmployee(employee);
        return "redirect:/";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id){
    this.employeesServices.deleteEmployeeById(id);
    return "redirect:/";
    }
}
