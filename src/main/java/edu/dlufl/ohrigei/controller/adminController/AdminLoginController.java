package edu.dlufl.ohrigei.controller.adminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminLoginController {
    @RequestMapping("/admin")
    public String adminIndex(){
        return "admin/adminIndex";
    }
}
