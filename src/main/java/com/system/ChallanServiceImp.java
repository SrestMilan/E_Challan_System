package com.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChallanServiceImp implements ChallanService{
    @Autowired
    private ChallanRepo challan_repo;
    @Override
    public List<Challanfield> getChallanInformation() {
        return challan_repo.findAll();
    }

    @Override
    public void saveChallanData(Challanfield challan_save) {
        this.challan_repo.save(challan_save);
    }

    @Override
    public Challanfield getChallanUserById(long id) {
        Optional< Challanfield > optional1 = challan_repo.findById(id);
        Challanfield challan_save = null;
        if (optional1.isPresent()) {
            challan_save = optional1.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
       return challan_save;
    }

    @Override
    public void deleteChallanDataById(long id) {
        this.challan_repo.deleteById(id);
    }
}
