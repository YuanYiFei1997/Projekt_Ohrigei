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
    List<Delegate> memberList = new LinkedList<>()
    @Override
    String  queryMembers(HttpSession session, Model model, String type) {
        switch (type) {
            case "delegate":
                memberList = adminDao.queryAllMember(1)
                model.addAttribute("memberList",memberList)
                model.addAttribute("代表列表",queryType)
                return "/admin/AllMemberList"
            case "observer":
                memberList =adminDao.queryAllMember(2)
                model.addAttribute("memberList",memberList)
                model.addAttribute("观察员列表",queryType)
                return adminDao.queryAllObserver()
            case "leader":
                memberList =adminDao.queryAllMember(4)
                model.addAttribute("memberList",memberList)
                model.addAttribute("领队",queryType)
                return adminDao.queryAllLeader()
            case "teacher":
                memberList=adminDao.queryAllMember(3)
                model.addAttribute("memberList",memberList)
                model.addAttribute("指导教师列表")
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
