package com.projectjee.emsbackend.service;

import com.projectjee.emsbackend.dto.employeedto;

import java.util.List;

public interface EmployeeService {
    employeedto createEmployee(employeedto employeedto);
    employeedto getEmployeeById(Long employeeId);
    List<employeedto> getAllEmployees();
    employeedto updateEmployee(Long employeeId, employeedto updatedemployee);
    void deleteEmployee(Long employeeId);
}
