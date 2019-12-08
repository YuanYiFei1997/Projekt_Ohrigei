package edu.dlufl.ohrigei.controller.adminController;

import edu.dlufl.ohrigei.model.User;
import edu.dlufl.ohrigei.service.adminService.service.AdminQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminQueryService adminQueryService;

    @RequestMapping("/dashBoard")
    public String dashboard() {
        return "admin/dashBoard";
    }
    @RequestMapping("/manage")
    public List<User> queryMembers(HttpSession session, Model model, String type) {
        switch(type){
            case "delegate":break;
            case "Observer":break;
            case "Teacher":break;
            case "Admin":break;
            case "Committee":break;
            case "Group":break;
            case "Seat":break;
        }
        return adminQueryService.queryMembers(session, model, type);
    }
}
