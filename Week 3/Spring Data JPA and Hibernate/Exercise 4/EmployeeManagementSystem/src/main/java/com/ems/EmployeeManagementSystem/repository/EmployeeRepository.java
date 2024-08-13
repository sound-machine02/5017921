package com.ems.EmployeeManagementSystem.repository;

import com.ems.EmployeeManagementSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String name);

    List<Employee> findByDepartment(int departmentId);

    List<Employee> findByEmailContaining(String email);
}