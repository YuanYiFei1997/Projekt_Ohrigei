package edu.dlufl.ohrigei.service.adminService.impl

import edu.dlufl.ohrigei.dao.AdminDao
import edu.dlufl.ohrigei.model.Admin
import edu.dlufl.ohrigei.model.Committee
import edu.dlufl.ohrigei.model.Delegate
import edu.dlufl.ohrigei.model.Group
import edu.dlufl.ohrigei.service.adminService.service.AdminQueryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.ui.Model

import javax.servlet.http.HttpSession

@Service("AdminQueryMembersService")
class AdminQueryServiceImpl implements AdminQueryService {
    @Autowired
    AdminDao adminDao

    @Override
    List<Delegate> queryMembers(HttpSession session, Model model, String type) {
        switch (type) {
            case "allDelegate":
                List<Delegate> delegateList = adminDao.queryAllDelegate()
                model.addAttribute("delegateList",delegateList)
                return adminDao.queryAllDelegate()
            case "allObserver":
                List<Delegate> observerList =adminDao.queryAllObserver()
                model.addAttribute("observerList",observerList)
                return adminDao.queryAllObserver()
            case "allLeader":
                List<Delegate> leaderList =adminDao.queryAllLeader()
                model.addAttribute("leaderList",leaderList)
                return adminDao.queryAllLeader()
            case "allTeacher":
                List<Delegate> teacherList=adminDao.queryAllTeacher()
                model.addAttribute("teacherList",teacherList)
                return adminDao.queryAllTeacher()
            default: return null
        }
    }

    @Override
    List<Admin> queryAdmin(HttpSession session, Model model) {
        List<Admin> adminList = adminQueryService.queryAdmin(session, model)
        model.addAttribute("adminList", adminList)
        return adminDao.queryAllAdmin()
    }

    @Override
    List<Group> queryGroup(HttpSession session, Model model) {
        List<Group> groupList = adminQueryService.queryGroup(session, model)
        model.addAttribute("groupList", groupList)
        return adminDao.queryAllGroup()
    }

    @Override
    List<Committee> queryCommittee(HttpSession session, Model model) {
        List<Committee> committeeList = adminQueryService.queryCommittee(session, model)
        model.addAttribute("committeeList", committeeList)
        return adminDao.queryAllCommittee()
    }
}
