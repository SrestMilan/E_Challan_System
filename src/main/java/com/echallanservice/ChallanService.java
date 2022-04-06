package com.echallanservice;

import com.model.Challanfield;
import java.util.List;

public interface ChallanService {
    List <Challanfield> getAllEChallan();
    void saveEmployee(Challanfield challan);
    Challanfield getEmployeeById(long id);
    void deleteChallanfieldByid(long id);
}
