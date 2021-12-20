package com.sm.service.impl;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.sm.model.Employee;
import com.sm.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final String EMPLOYEE_DB = "employee";

    @Override
    public String create(Employee employee) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection(EMPLOYEE_DB)
                .document(employee.getDocument_id())
                .set(employee);
        return apiFuture.get().getUpdateTime().toString();
    }

    @Override
    public Employee getByDocumentId(String documentId) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection(EMPLOYEE_DB).document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Employee employee = null;
        if(document.exists())
            employee = document.toObject(Employee.class);
        return employee;
    }

    @Override
    public String update(String documentId, Employee employee) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(EMPLOYEE_DB)
                .document(documentId)
                .set(employee);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String delete(String document_id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(EMPLOYEE_DB).document(document_id).delete();
        return "Document with Employee ID "+document_id+" has been deleted";
    }
}
