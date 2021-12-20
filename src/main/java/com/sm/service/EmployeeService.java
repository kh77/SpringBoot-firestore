package com.sm.service;

import com.sm.model.Employee;

import java.util.concurrent.ExecutionException;

public interface EmployeeService {

    String create(Employee employee) throws ExecutionException, InterruptedException;

    Employee getByDocumentId(String documentId) throws ExecutionException, InterruptedException;

    String update(String documentId, Employee employee) throws ExecutionException, InterruptedException;

    String delete(String documentId);
}
