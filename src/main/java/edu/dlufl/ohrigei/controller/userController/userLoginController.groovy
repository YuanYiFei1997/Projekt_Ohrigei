package edu.dlufl.ohrigei.controller.userController

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class userLoginController {
    @RequestMapping("/login")
    public String userLogin(){
        return "user/userLogin"
    }
}
