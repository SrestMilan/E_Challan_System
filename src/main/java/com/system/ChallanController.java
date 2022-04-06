package com.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/showNewEChallanForm")
    public String showNewEChallanForm(Model model){
        Challanfield challan_save = new Challanfield();
        model.addAttribute("challan_save", challan_save);
        return "new_challandata";

    }

    @PostMapping("/saveChallanData")
    public String saveChallanData(@ModelAttribute("challan_save") Challanfield challan_save) {
        // save employee to database
        challan_serv.saveChallanData(challan_save);
        return "redirect:/";
    }

    @GetMapping("/updateForm/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Challanfield challan_save = challan_serv.getChallanUserById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("challan_save", challan_save);
        return "update_challanfield";
    }

    @GetMapping("/deleteChallanData/{id}")
    public String deleteData(@PathVariable(value = "id") long id) {

        // call delete employee method
        this.challan_serv.deleteChallanDataById(id);
        return "redirect:/";
    }
}
