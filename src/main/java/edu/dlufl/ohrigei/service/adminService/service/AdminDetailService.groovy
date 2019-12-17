package edu.dlufl.ohrigei.service.adminService.service

import org.springframework.stereotype.Service
import org.springframework.ui.Model

import javax.servlet.http.HttpSession

@Service
interface AdminDetailService {
    String adminDetail(HttpSession httpSession, Model model,String id)
}
