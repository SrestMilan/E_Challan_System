package com.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChallanController {
    @Autowired
    private ChallanService challan_serv;

    // display list of employees
    @GetMapping("/")
    public String viewAdminPage(Model model) {
        model.addAttribute("challandata",challan_serv.getChallanInformation());
        return "admin";
    }
}
