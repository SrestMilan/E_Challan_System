package com.system;
import java.util.List;
public interface ChallanService {
    List<Challanfield> getChallanInformation();
    void saveChallanData(Challanfield challan_save);
    Challanfield getChallanUserById(long id);
    void deleteChallanDataById(long id);

}
