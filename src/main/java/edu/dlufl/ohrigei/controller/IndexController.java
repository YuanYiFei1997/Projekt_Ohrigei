package edu.dlufl.ohrigei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "Login";
    }
    @RequestMapping("user/Index")
    public String userIndex(){
        return "user/UserIndex";
    }

}
