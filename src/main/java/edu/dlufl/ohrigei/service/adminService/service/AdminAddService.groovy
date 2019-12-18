package edu.dlufl.ohrigei.service.adminService.service

import edu.dlufl.ohrigei.model.Admin
import org.springframework.stereotype.Service
import org.springframework.ui.Model

import javax.servlet.http.HttpSession

@Service
interface AdminAddService {
    String addAdmin(HttpSession httpSession, Model model, Admin admin)
}