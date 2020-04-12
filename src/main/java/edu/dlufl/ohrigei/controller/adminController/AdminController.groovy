package edu.dlufl.ohrigei.controller.adminController

import edu.dlufl.ohrigei.dao.UserDao
import edu.dlufl.ohrigei.model.User
import edu.dlufl.ohrigei.service.adminService.service.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import javax.servlet.http.HttpSession

@Controller
@RequestMapping("/admin")
class AdminController {
    @Autowired
    AdminQueryService adminQueryService
    @Autowired
    AdminAddService adminAddService
    @Autowired
    AdminCountService adminCountService
    @Autowired
    AdminModifyService adminModifyService
    @Autowired
    AdminDeleteService adminDeleteService
    @Autowired
    UserDao userDao

    @RequestMapping("/DashBoard")
    String dashboard(Authentication authentication, HttpSession httpSession, Model model) {
        String email = authentication.getName()
        User userInfo = userDao.getUserByEmail(email)
        httpSession.setAttribute("USER_INFO", userInfo)
        return adminCountService.countDelegate(model, httpSession);
    }

    @RequestMapping("/profile")
    String profile(HttpSession session) {
        return "admin/AdminPersonalProfile"
    }

    @RequestMapping("/manage")
    String queryMembers(HttpSession session, Model model, String type) {
        switch (type) {
            case "admin":
                return adminQueryService.queryAdmin(session, model)
            case "committee":
                return adminQueryService.queryCommittee(session, model)
            case "group":
                return adminQueryService.queryGroup(session, model)
            case "seat": break
            default:
                try {
                    return adminQueryService.queryMembers(session, model, type)
                }
                catch (Exception e) {
                    System.out.println("An error occur" + e)
                }
        }
        return "admin/DashBoard"
    }

    @RequestMapping("/addAdminPage")
    String addAdmin() {
        return "admin/AddAdmin"
    }

    @RequestMapping("/addCommitteePage")
    String addCommitteePage(Model model) {
        adminQueryService.queryAdminIDAndName(model)
    }

    @RequestMapping("/committeeListPage")
    String committeeList(Model model) {
        return adminQueryService.queryAllCommittee(model)
    }

    @RequestMapping("/addSeatPage")
    String addSeatPage(Model model) {
        return adminQueryService.queryCommitteeIDAndName(model)
    }

    @RequestMapping("/adminDetail")
    String adminDetail(Model model, HttpSession httpSession, String id) {
        return adminQueryService.adminDetail(httpSession, model, id)
    }

    @RequestMapping("/addGroupPage")
    String addGroup(Model model) {
        return adminQueryService.queryAllDelegateAndSchool(model)
    }

    @RequestMapping("/groupDetailPage")
    String groupDetail(Model model) {
        return adminQueryService.queryAllGroup(model)
    }

    @RequestMapping("/addSchoolPage")
    String addSchoolPage(Model model) {
        return adminQueryService.queryAllSchoolType(model)
    }

    @RequestMapping("/modifyGroupPage")
    String modifyGroup(Model model, String groupID) {
        return adminQueryService.queryGroupById(model, groupID)
    }

    @RequestMapping("/groupMemberDetail")
    String groupMemberDetail(Model model, String groupID) {
        return adminQueryService.groupMemberDetail(model,groupID)
    }

    @RequestMapping("/memberDetailPage")
    String memberDetailPage(Model model, String id) {
        int ID = Integer.parseInt(id)
        return adminQueryService.queryMemberByID(model, ID)
    }

    @RequestMapping("/allSchoolList")
    String allSchoolList(Model model) {
        adminQueryService.queryAllSchool(model)
    }

    @RequestMapping("/allSeatList")
    String allSeatList(Model model) {
        return adminQueryService.queryAllSeat(model)
    }

    @RequestMapping("/addInterview")
    String addInterview(Model model) {
        return adminQueryService.queryDelegateAndAdmin(model)
    }

    @RequestMapping("/interviewList")
    String interviewList(Model model, HttpSession session, String type) {
        return adminQueryService.queryInterviewList(model, session, type)
    }

    @RequestMapping("/interviewDetail")
    String interviewDetail(Model model, String delegateID) {
        return adminQueryService.queryInterviewByID(model, delegateID)
    }

    @RequestMapping("/allBillList")
    String allBillList(Model model, String type) {
        return adminQueryService.queryBillList(model, type)
    }

    @RequestMapping("/billDetail")
    String billDetail(Model model, String id) {
        return adminQueryService.queryBillDetail(model, id)
    }

    @RequestMapping("/seatWaitProcess")
    String seatWaitProcess(Model model) {
        return adminQueryService.querySeatWaitProcess(model)
    }
}
