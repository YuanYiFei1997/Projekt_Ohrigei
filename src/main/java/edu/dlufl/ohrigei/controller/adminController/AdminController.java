package edu.dlufl.ohrigei.controller.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/dashBoard")
    public String dashboard(){
        return "admin/dashboard";
    }
}
