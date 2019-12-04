package edu.dlufl.ohrigei.controller.userController;

import edu.dlufl.ohrigei.model.User;
import edu.dlufl.ohrigei.service.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/Login")
    public String Login(@ModelAttribute(value = "userInfo") User user, HttpSession session, Model model) {
        return userService.loginCheck(user, session, model);
    }

    @RequestMapping("/signUp")
    public String signUp(Model model,HttpSession httpSession) {
        model.addAttribute("User",new User());
        return "user/UserSignUp";
    }

    @RequestMapping("/index")
    public String toIndex() {
        return "user/UserIndex";
    }
}
