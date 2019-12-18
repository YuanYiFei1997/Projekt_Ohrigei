package edu.dlufl.ohrigei.service.adminService.impl

import edu.dlufl.ohrigei.dao.AdminDao
import edu.dlufl.ohrigei.model.Admin
import edu.dlufl.ohrigei.service.adminService.service.AdminAddService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.ui.Model

import javax.servlet.http.HttpSession

@Service("AdminAddService")
class AdminAddServiceImpl implements AdminAddService {
    @Autowired
    AdminDao adminDao

    String addAdmin(HttpSession session, Model model, Admin admin) throws UsernameNotFoundException {
        if (adminDao.emailCheck(admin.getEmail()) != null) {
            throw new UsernameNotFoundException("邮箱已被使用")
        }
        String password = new BCryptPasswordEncoder().encode(admin.getPassword())
        admin.setPassword(password)
        adminDao.addAdminStep1(admin)
        admin.setId(adminDao.getInsertID(admin.getEmail()))
        adminDao.addAdminStep2(admin)
        model.addAttribute("message", "添加管理员成功")
        return "admin/AddAdmin"
    }
}
