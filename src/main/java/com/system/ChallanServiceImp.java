package com.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallanServiceImp implements ChallanService{
    @Autowired
    private ChallanRepo challan_repo;
    @Override
    public List<Challanfield> getChallanInformation() {
        return challan_repo.findAll();
    }
}
