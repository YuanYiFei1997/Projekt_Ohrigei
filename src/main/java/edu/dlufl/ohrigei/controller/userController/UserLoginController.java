package edu.dlufl.ohrigei.controller.userController;

import edu.dlufl.ohrigei.service.userService.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserLoginController {
    @Autowired
    private UserLoginService userLoginService;
    @RequestMapping("/login")
    public String toLogin(String email,String password){
        userLoginService.loginCheck(email,password);
    }
}
