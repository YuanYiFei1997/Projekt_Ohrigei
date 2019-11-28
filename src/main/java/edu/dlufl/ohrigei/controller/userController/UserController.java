package edu.dlufl.ohrigei.controller.userController;

import edu.dlufl.ohrigei.service.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/Login")
    public String Login(String inputEmail , String inputPassword) {
        if (inputEmail==null||inputPassword==null){
            return "Login";
        }
        if (userService.loginCheck(inputEmail,inputPassword)){
            if (userService.authorityCheck(inputEmail)){
                return "redirect:/admin/dashBoard";
            }
            return "user/UserIndex";
        }
        else return "Login";
    }
    @RequestMapping("/signUp")
    public String signUp(){
        return "user/UserSignUp";
    }
}
