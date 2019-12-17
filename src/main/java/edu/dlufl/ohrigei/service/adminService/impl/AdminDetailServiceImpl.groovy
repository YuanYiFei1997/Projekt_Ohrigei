package edu.dlufl.ohrigei.service.adminService.impl

import edu.dlufl.ohrigei.dao.AdminDao
import edu.dlufl.ohrigei.model.Admin
import edu.dlufl.ohrigei.service.adminService.service.AdminDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.ui.Model

import javax.servlet.http.HttpSession

@Service("AdminDetailService")
class AdminDetailServiceImpl implements AdminDetailService{
    @Autowired
    AdminDao adminDao
    @Override
    String adminDetail(HttpSession httpSession, Model model, String id) {
        int ID=Integer.parseInt(id)
        Admin admin = adminDao.adminDetail(ID)
        model.addAttribute("admin",admin)
        return "admin/AdminDetail"
    }
}
