package com.system;

import java.util.List;
public interface ChallanService {
    List <Challanfield> getAllEmployees();
    void saveEmployee(Challanfield employee);
    Challanfield getEmployeeById(long id);
    void deleteEmployeeById(long id);
}
