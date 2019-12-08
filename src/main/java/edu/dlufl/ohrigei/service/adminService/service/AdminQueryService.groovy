package edu.dlufl.ohrigei.service.adminService.service

import edu.dlufl.ohrigei.model.User
import org.springframework.stereotype.Service
import org.springframework.ui.Model

import javax.servlet.http.HttpSession

@Service
interface AdminQueryService {
    List<User> queryMembers(HttpSession session, Model model, String act)
}