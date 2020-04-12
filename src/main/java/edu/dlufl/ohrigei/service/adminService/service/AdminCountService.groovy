package edu.dlufl.ohrigei.service.adminService.service

import org.springframework.stereotype.Service
import org.springframework.ui.Model

import javax.servlet.http.HttpSession

@Service
interface AdminCountService {
    String countDelegate(Model model, HttpSession httpSession)
}