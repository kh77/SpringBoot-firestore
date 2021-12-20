package com.sm.controller;

import com.sm.model.Employee;
import com.sm.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("{document-id}")
    public Employee findEmployeeByDocumentId(@PathVariable("document-id") String documentId) throws ExecutionException, InterruptedException {
        return employeeService.getByDocumentId(documentId);
    }

    @PostMapping
    public String createEmployee(@RequestBody Employee employee) throws ExecutionException, InterruptedException {
        return employeeService.create(employee);
    }

    @PutMapping("{document-id}")
    public String updateEmployee(@PathVariable("document-id") String documentId, @RequestBody Employee employee) throws ExecutionException, InterruptedException {
        return employeeService.update(documentId, employee);
    }

    @DeleteMapping("{document-id}")
    public String deleteEmployee(@PathVariable("document-id") String documentId) {
        return employeeService.delete(documentId);
    }
}