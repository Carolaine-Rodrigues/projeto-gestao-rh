package br.com.api.rh.api.domain.entity;

import br.com.api.rh.api.domain.dto.EmployeeRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name= "employees")
@Entity(name= "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String position;
    BigDecimal salary;
    LocalDate hireDate;

    public Employee(EmployeeRequestDTO data){
        this.name = data.name();
        this.email = data.email();
        this.position = data.position();
        this.salary = data.salary();
        this.hireDate = data.hireDate();
    }
}

