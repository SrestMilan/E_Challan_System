package com.system;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChallanServiceFunc implements ChallanService {

    @Autowired
    private ChallanRepository challan_repo;


    @Override
    public List<Challanfield> getAllChallanInformation() {
        return challan_repo.findAll();
    }

    @Override
    public void saveChallanData(Challanfield challan_save) {
        this.challan_repo.save(challan_save);
    }

    @Override
    public Challanfield getChallanDataById(long id) {
        Optional <Challanfield> optional = challan_repo.findById(id);
        Challanfield challan_save = null;
        if (optional.isPresent()) {
            challan_save = optional.get();
        } else {
            throw new RuntimeException(" Challan data not found for id :: " + id);
        }
        return challan_save;
    }

    @Override
    public void deleteChallanDataById(long id) {
        this.challan_repo.deleteById(id);
    }

}
