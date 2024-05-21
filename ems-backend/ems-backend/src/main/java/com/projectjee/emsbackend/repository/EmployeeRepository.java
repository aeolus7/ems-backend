package com.projectjee.emsbackend.repository;

import com.projectjee.emsbackend.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<employee,Long> {

}
