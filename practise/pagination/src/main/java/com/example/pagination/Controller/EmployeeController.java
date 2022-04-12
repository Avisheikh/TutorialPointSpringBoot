//package com.example.pagination.Controller;
//
//import com.example.pagination.DTO.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class EmployeeController
//{
//    @Autowired
//    EmployeeService employeeService;
//
//    @GetMapping("/employees")
//    private List getAllEmployess()
//    {
//        return employeeService.getAllEmployees();
//    }
//
//    @GetMapping("/employees/{id}")
//    private Employee getEmployeeById(@PathVariable("id") int id)
//    {
//        return employeeService.getEmployeeById(id);
//    }
//
//    @PostMapping("/employees")
//    private Employee createEmployee(@RequestBody Employee employee)
//    {
//        employeeService.saveOrUpdate(employee);
//        return employee;
//    }
//
//    @PutMapping("/employess/{id}")
//    private Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee)
//    {
//        Employee updateEmployee = employeeService.getEmployeeById(id);
//        updateEmployee.setName(employee.getName());
//        updateEmployee.setSalary(employee.getSalary());
//        employeeService.saveOrUpdate(updateEmployee);
//        return updateEmployee;
//    }
//
//    @DeleteMapping("/employees/{id}")
//    private Employee deleteById(@PathVariable("id") int id)
//    {
//        Employee employeeDeleted = employeeService.getEmployeeById(id);
//        employeeService.delete(id);
//        return employeeDeleted;
//    }
//}
