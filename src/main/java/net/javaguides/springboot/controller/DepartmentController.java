package net.javaguides.springboot.controller;


import net.javaguides.springboot.model.Department;
import net.javaguides.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        Department savedDepartment = departmentService.createDepartment(department);
        return ResponseEntity.ok(savedDepartment);
    }

    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
        Department department = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }
}
