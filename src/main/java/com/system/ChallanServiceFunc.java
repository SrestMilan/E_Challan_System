package com.system;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChallanServiceFunc implements ChallanService {

    @Autowired
    private ChallanRepository employeeRepository;

    @Override
    public List <Challanfield> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Challanfield employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Challanfield getEmployeeById(long id) {
        Optional <Challanfield> optional = employeeRepository.findById(id);
        Challanfield employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }
}
