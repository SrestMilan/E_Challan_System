package com.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallanServiceImp implements ChallanService {

    @Autowired
    private ChallanRepo challanRepos;


    @Override
    public List<Challanfiled> getChallanInformation() {
        return challanRepos.findAll();
    }
}
