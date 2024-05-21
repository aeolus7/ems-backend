package com.projectjee.emsbackend.service.empl;

import com.projectjee.emsbackend.dto.employeedto;
import com.projectjee.emsbackend.entity.employee;
import com.projectjee.emsbackend.exception.ResourceNotFoundException;
import com.projectjee.emsbackend.mapper.employeeMapper;
import com.projectjee.emsbackend.repository.EmployeeRepository;
import com.projectjee.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class employeeServiceempl implements EmployeeService {
    EmployeeRepository employeeRepository;
    @Override
    public employeedto createEmployee(employeedto employeedto) {
        employee employee= employeeMapper.MapToemployee(employeedto);
        employee savedEmployee=employeeRepository.save(employee);
        return employeeMapper.MapToemployeedto(savedEmployee);
    }

    @Override
    public employeedto getEmployeeById(Long employeeId) {
       employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundException("employee not found with the given id!" +employeeId));
        return employeeMapper.MapToemployeedto(employee);
    }

    @Override
    public List<employeedto> getAllEmployees() {
        List<employee> employees= employeeRepository.findAll();
        return employees.stream().map((employee) -> employeeMapper.MapToemployeedto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public employeedto updateEmployee(Long employeeId, employeedto updatedemployee) {
        employee employee=employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("cant find the employee u want to update with the id provided" + employeeId));
        employee.setFirstname(updatedemployee.getFirstname());
        employee.setLastname(updatedemployee.getLastname());
        employee.setEmail(updatedemployee.getEmail());
        employee updatedEmployeeobj=employeeRepository.save(employee);

        return employeeMapper.MapToemployeedto(updatedEmployeeobj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employee employee=employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("cant find the employee u want to update with the id provided" + employeeId));
    employeeRepository.deleteById(employeeId);
    }
}
