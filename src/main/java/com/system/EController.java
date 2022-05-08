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

    @GetMapping("/")
    public String login(){
        return "homepage";
    }



    @RequestMapping(value = "/", method=RequestMethod.POST)
    public String viewTraf(ModelMap model, @RequestParam String userName, @RequestParam String password){
        if(userName.equals("admin")&& password.equals("admin")){
            return "redirect:/viewHomePage";
        }
        else if(userName.equals("traffic")&& password.equals("traffic")){
            return "redirect:/viewTraffic";
        }
        else{
            return "homepage";
        }
    }



    @GetMapping("/viewHomePage")
    public String viewHomePage(Model model) {
        model.addAttribute("challanData", challanRepo.getAllChallanInformation());
        return "admin";
    }


    @GetMapping("/viewTraffic")
    public String viewTraffic(Model model) {
        model.addAttribute("challanData", challanRepo.getAllChallanInformation());
        return "traffic";
    }




    @GetMapping("/newChallanForm")
    public String newChallanForm(Model model) {
        Challanfield challan_save = new Challanfield();
        model.addAttribute("challan_save", challan_save);
        List<String>type= Arrays.asList("Drinking Alcohol","No helmet","No side light","High Speed");
        model.addAttribute("type",type);

        List<String>create= Arrays.asList("Traffic");
        model.addAttribute("create",create);

        List<String>v_type= Arrays.asList("Two Wheeler", "Three Wheller","Four Wheeler");
        model.addAttribute("v_type",v_type);

        return "new_challanform";
    }

    @PostMapping("/saveEChallanData")
    public String saveEChallanData(@ModelAttribute("challan_save") Challanfield challan_save) {
        challanRepo.saveChallanData(challan_save);
        return "redirect:/viewTraffic";
    }




    @GetMapping("/formUpdate/{id}")
    public String formUpdate(@PathVariable(value = "id") long id, Model model) {
        Challanfield challan_save = challanRepo.getChallanDataById(id);
        model.addAttribute("challan_save",challan_save);
        List<String>type= Arrays.asList("Drinking Alcohol","No helmet","No side light","High Speed");
        model.addAttribute("type",type);

        List<String>create= Arrays.asList("Traffic");
        model.addAttribute("create",create);

        List<String>v_type= Arrays.asList("Two Wheeler", "Three Wheller","Four Wheeler");
        model.addAttribute("v_type",v_type);
        return "update_challanform";
    }

    @GetMapping("/deleteData/{id}")
    public String deleteData(@PathVariable(value = "id") long id) {
        this.challanRepo.deleteChallanDataById(id);
        return "redirect:/viewHomePage";
    }

}