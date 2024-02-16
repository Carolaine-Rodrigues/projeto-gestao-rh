package br.com.api.rh.api.domain.service;


import br.com.api.rh.api.domain.dto.EmployeeRequestDTO;
import br.com.api.rh.api.domain.entity.Employee;
import br.com.api.rh.api.domain.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    //Métado de cadastro de dados
    public Employee saveEmployees(EmployeeRequestDTO data){
        var employeeData = new Employee(data);
        employeeRepository.save(employeeData);
        return employeeData;
    }

    // Métado que atualiza dados.
    public Employee updateEmployees(Long id, EmployeeRequestDTO update){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if(optionalEmployee.isPresent()){
            Employee updateEmployee = optionalEmployee.get();
            if (update.name()!= null){
                updateEmployee.setName(update.name());
            }
            if (update.email()!= null){
                updateEmployee.setEmail(update.email());
            }
            if (update.position()!= null){
                updateEmployee.setPosition(update.position());
            }
            if (update.salary()!= null){
                updateEmployee.setSalary(update.salary());
            }
            if (update.hireDate()!= null){
                updateEmployee.setHireDate(update.hireDate());
            }
            employeeRepository.save(updateEmployee);
            return updateEmployee;
        }else {
            throw new EntityNotFoundException();
        }
    }
    // Lista todas as pessoas
    public List<Employee> listAllEmployees(){
        List<Employee> list = employeeRepository.findAll();
        return list;
    }
    //Lista uma pessoa por id
    public Employee listEmployeeId(Long id){
        var employee = employeeRepository.findById(id).get();
        return employee;
    }
    //exclui pessoa por id
    public void deleteId(Long id){
        Optional<Employee> deleteEmployee = employeeRepository.findById(id);
        if(deleteEmployee.isPresent()){
            Employee employee = deleteEmployee.get();
            employeeRepository.delete(employee);
        }else {
            throw new EntityNotFoundException();
        }
    }
}
