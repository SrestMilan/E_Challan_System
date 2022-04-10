package com.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Controller
public class ChallanController {

    @Autowired(required = true)
    private ChallanService challanRepo;





    @GetMapping("/")
    public String login(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "login";
    }




    // display list of employees
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

        List<String>type= Arrays.asList("Drinking Alcohol","No helmet");
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
        List<String>type= Arrays.asList("Drinking Alcohol","No helmet");
        model.addAttribute("type",type);
        return "update_challanform";
    }

    @GetMapping("/deleteData/{id}")
    public String deleteData(@PathVariable(value = "id") long id) {
        this.challanRepo.deleteChallanDataById(id);
        return "redirect:/viewHomePage";
    }

}