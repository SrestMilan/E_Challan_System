package com.system;

import java.util.List;
public interface ChallanService {
    List <Challanfield> getAllChallanInformation();
    void saveChallanData(Challanfield challan_save);
    Challanfield getChallanDataById(long id);
    void deleteChallanDataById(long id);
}
