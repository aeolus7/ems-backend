package com.projectjee.emsbackend.mapper;

import com.projectjee.emsbackend.dto.employeedto;
import com.projectjee.emsbackend.entity.employee;

public class employeeMapper {
    public static employeedto MapToemployeedto(employee employee){
        return new employeedto(
                employee.getId(),
                employee.getEmail(),
                employee.getFirstname(),
                employee.getLastname()
        );
    }
    public static employee MapToemployee(employeedto employeedto){
        return new employee(
                employeedto.getId(),
                employeedto.getFirstname(),
                employeedto.getLastname(),
                employeedto.getEmail()
        );
    }
}
