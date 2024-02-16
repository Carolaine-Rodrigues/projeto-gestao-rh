package br.com.api.rh.api.domain.dto;

import br.com.api.rh.api.domain.entity.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeResponseDTO(Long id, String name, String email, String position, BigDecimal salary, LocalDate hireDate) {
    public EmployeeResponseDTO(Employee employee){
        this(employee.getId(), employee.getName(), employee.getEmail(), employee.getPosition(), employee.getSalary(),employee.getHireDate());
    }
}

