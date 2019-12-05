package edu.dlufl.ohrigei.service.adminService.impl

import edu.dlufl.ohrigei.dao.AdminDao
import edu.dlufl.ohrigei.model.User
import edu.dlufl.ohrigei.service.adminService.service.AdminQueryMembersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.ui.Model

import javax.servlet.http.HttpSession

@Service("AdminQueryMembersService")
class AdminQueryMembersServiceImpl implements AdminQueryMembersService{
    @Autowired
    AdminDao adminDao
    @Override
    List<User> queryMembers(HttpSession session, Model model, String act) {
        List<User> userList = new ArrayList<>()
        switch (act){
            case "allDelegate":adminDao.queryAllDelegate()
                break
            case "allObserver":adminDao.queryAllObserver()
                break
            case "allLeader":adminDao.queryAllLeader()
                break
            case "allTeacher":adminDao.queryAllTeacher()
                break
        }
        return userList
    }
}
