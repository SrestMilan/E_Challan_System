package com.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;



@Controller
public class EController {

    @Autowired(required = true)
    private ChallanService challanRepo;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login", method=RequestMethod.POST)
    public String viewHomePage(ModelMap model, @RequestParam String userName, @RequestParam String password){
        if(userName.equals("admin")&& password.equals("admin")){
            return "admin";
        }
        else{
            return "login";
        }
    }



    @GetMapping("/viewHomePage")
    public String viewHomePage(Model model) {
        model.addAttribute("challanData", challanRepo.getAllChallanInformation());
        return "admin";
    }




    @GetMapping("/newChallanForm")
    public String newChallanForm(Model model) {
        // create model attribute to bind form data
        Challanfield challan_save = new Challanfield();
        model.addAttribute("challan_save", challan_save);
        List<String>type= Arrays.asList("Drinking Alcohol","No helmet","No side light","High Speed");
        model.addAttribute("type",type);
        return "new_challanform";
    }

    @PostMapping("/saveEChallanData")
    public String saveEChallanData(@ModelAttribute("challan_save") Challanfield challan_save) {
        // save employee to database
        challanRepo.saveChallanData(challan_save);
        return "redirect:/viewHomePage";
    }


    @GetMapping("/formUpdate/{id}")
    public String formUpdate(@PathVariable(value = "id") long id, Model model) {
        Challanfield challan_save = challanRepo.getChallanDataById(id);
        model.addAttribute("challan_save",challan_save);
        List<String>type= Arrays.asList("Drinking Alcohol","No helmet","No side light","High Speed");
        model.addAttribute("type",type);
        return "update_challanform";
    }

    @GetMapping("/deleteData/{id}")
    public String deleteData(@PathVariable(value = "id") long id) {
        this.challanRepo.deleteChallanDataById(id);
        return "redirect:/viewHomePage";
    }
    @GetMapping("/homepage")
    public String homepage(Model model) {
        model.addAttribute("challanData", challanRepo.getAllChallanInformation());
        return "homepage";
    }

}