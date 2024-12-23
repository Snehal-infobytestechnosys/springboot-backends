package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    //build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }



    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();

    }

    //build get employee by id REST API
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
       Optional<Employee> employee = employeeService.getEmployeeById(id);

        return employee.map(ResponseEntity:: ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updateEmployee);
    }

    //build delete employee REST API
     @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long id){

       employeeService.deleteEmployee(id);
       return ResponseEntity.noContent().build();
    }



}
