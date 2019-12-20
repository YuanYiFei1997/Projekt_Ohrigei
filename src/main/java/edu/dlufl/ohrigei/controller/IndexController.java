package edu.dlufl.ohrigei.controller;

import edu.dlufl.ohrigei.model.User;
import edu.dlufl.ohrigei.service.adminService.service.AdminCountService;
import edu.dlufl.ohrigei.service.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    int cont = 0;
    @Autowired
    AdminCountService adminCountService;
    @Autowired
    UserService userService;
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        model.addAttribute("userInfo", new User());
        model.addAttribute("errorMessage");
        if(session.getAttribute("user")!=null){
            return "user/UserIndex";
        }
        return "allUser/index";
    }
    @RequestMapping("/testIndex")
    public String testIndex(Model model,HttpSession httpSession){
        return adminCountService.countDelegate(model,httpSession);
    }
    @RequestMapping("/testUpload")
    public String testUpload(){
        return "allUser/testUpload";
    }
    @RequestMapping("/header")
    public String header(){
        return "allUser/header";
    }
    @RequestMapping("/question")
    public String question(){
        return "user/UserAcademicTest";
    }
    @RequestMapping("/login")
    public String login(){
        return "allUser/login";
    }
    @RequestMapping("/signUp")
    public String SignUp(@ModelAttribute(value = "User") User user, Model model, HttpSession httpSession) {
        if (cont==0){
            model.addAttribute("User",new User());
            cont=cont+1;
            return "allUser/SignUp";
        }else {
            return userService.userSignUp(user,model);
        }
    }
}
