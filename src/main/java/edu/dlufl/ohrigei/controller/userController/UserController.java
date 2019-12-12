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
    int cont = 0;
    @RequestMapping(value = "/Login")
    public User Login(@ModelAttribute(value = "userInfo") User user, HttpSession session, Model model) {
        return userService.loginCheck(user, session, model);
    }

    @RequestMapping("/signUp")
    public String SignUp(@ModelAttribute(value = "User") User user,Model model,HttpSession httpSession) {

        if (cont==0){
            model.addAttribute("User",new User());
            cont=cont+1;
            return "user/UserSignUp";
        }else {
            return userService.userSignUp(user,model);
        }
    }

    @RequestMapping("/index")
    public String toIndex() {
        return "user/UserIndex";
    }
}
