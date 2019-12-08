package edu.dlufl.ohrigei.controller;

import edu.dlufl.ohrigei.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        model.addAttribute("userInfo", new User());
        model.addAttribute("errorMessage");
        if(session.getAttribute("user")!=null){
            return "user/UserIndex";
        }
        return "Login";
    }
    @RequestMapping("/header")
    public String header(){
        return "header";
    }
    @RequestMapping("/question")
    public String question(){
        return "user/UserAcademicTest";
    }

}
