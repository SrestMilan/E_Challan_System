package com.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EChallanController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
