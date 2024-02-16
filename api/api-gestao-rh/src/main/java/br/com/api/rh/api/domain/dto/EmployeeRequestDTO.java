package br.com.api.rh.api.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmployeeRequestDTO(Long id, String name, String email, String position, BigDecimal salary, LocalDate hireDate) {
}

