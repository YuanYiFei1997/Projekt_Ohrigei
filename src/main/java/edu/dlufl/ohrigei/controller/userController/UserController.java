package edu.dlufl.ohrigei.controller.userController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/index")
    public String toIndex() {
        return "/user/UserIndex";
    }
}
