package edu.dlufl.ohrigei.controller.adminController;

import edu.dlufl.ohrigei.model.User;
import edu.dlufl.ohrigei.service.adminService.service.AdminQueryMembersService;
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
    AdminQueryMembersService adminQueryMembersService;

    @RequestMapping("/dashBoard")
    public String dashboard() {
        return "admin/dashBoard";
    }

    public List<User> queryMembers(HttpSession session, Model model, String act) {
        return adminQueryMembersService.queryMembers(session, model, act);
    }
}
