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
/**
 * @author yifei.yuan
 */
@Controller
public class IndexController {
    int CONT = 0;
    @Autowired
    AdminCountService adminCountService;
    @Autowired
    UserService userService;
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("USER_INFO")!=null){
            User user= (User) session.getAttribute("USER_INFO");
            if ("ROLE_ADMIN".equals(user.getRole())){
                return "redirect:admin/DashBoard";
            }else {
                return "redirect:user/UserIndex";
            }
        }
        return "allUser/login";
    }
    @RequestMapping("/login")
    public String login(){
        return "allUser/login";
    }
    @RequestMapping("/signUp")
    public String signUp(@ModelAttribute(value = "User") User user, Model model, HttpSession httpSession) {
        if (CONT==0){
            model.addAttribute("User",new User());
            CONT=CONT+1;
            return "allUser/register";
        }else {
            CONT=0;
            return userService.userSignUp(user,model);
        }
    }
}
