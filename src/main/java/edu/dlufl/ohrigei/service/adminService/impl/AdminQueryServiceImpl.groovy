package edu.dlufl.ohrigei.service.adminService.impl

import com.alibaba.fastjson.JSONObject
import edu.dlufl.ohrigei.dao.AdminDao
import edu.dlufl.ohrigei.model.*
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
    String queryType = new String()

    @Override
    String queryMembers(HttpSession session, Model model, String type) {
        switch (type) {
            case "delegate":
                memberList = adminDao.queryAllMember(1)
                model.addAttribute("memberList", memberList)
                queryType = "代表列表"
                model.addAttribute("queryType", queryType)
                return "/admin/AllMemberList"
            case "observer":
                memberList = adminDao.queryAllMember(2)
                model.addAttribute("memberList", memberList)
                queryType = "观察员列表"
                model.addAttribute("queryType", queryType)
                return "/admin/AllMemberList"
            case "teacher":
                memberList = adminDao.queryAllMember(3)
                model.addAttribute("memberList", memberList)
                queryType = "指导教师列表"
                model.addAttribute("queryType", queryType)
                return "/admin/AllMemberList"
            case "leader":
                memberList = adminDao.queryGroupLeaderList()
                model.addAttribute("memberList", memberList)
                queryType = "领队列表"
                model.addAttribute("queryType", queryType)
                return "/admin/AllMemberList"
            default: return null
        }
    }

    @Override
    String queryAllCommittee(Model model) {
        List<Committee> committeeList = adminDao.queryAllCommittee()
        model.addAttribute("committeeList", committeeList)
        return "admin/AllCommitteeList"
    }

    @Override
    String queryAdminIDAndName(Model model) {
        List<Admin> adminList = adminDao.queryAdminIDAndName()
        model.addAttribute("adminList", adminList)
        return "admin/AddCommittee"
    }

    @Override
    String queryCommitteeIDAndName(Model model) {
        List<Committee> committeeList = adminDao.queryCommitteeIDAndName()
        model.addAttribute("committeeList", committeeList)
        return "admin/AddSeat"
    }

    @Override
    String queryAdmin(HttpSession session, Model model) {
        List<Admin> adminList = adminDao.queryAllAdmin()
        model.addAttribute("adminList", adminList)
        return "admin/AllAdminList"
    }

    @Override
    List<Group> queryGroup(HttpSession session, Model model) {
        List<Group> groupList = adminDao.queryAllGroup()
        model.addAttribute("groupList", groupList)
        return adminDao.queryAllGroup()
    }

    @Override
    List<Committee> queryCommittee(HttpSession session, Model model) {
        List<Committee> committeeList = adminQueryService.queryCommittee(session, model)
        model.addAttribute("committeeList", committeeList)
        return adminDao.queryAllCommittee()
    }

    @Override
    String queryAllDelegateAndSchool(Model model) {
        List<School> schoolList = adminDao.queryAllSchool()
        List<Delegate> delegateList = adminDao.queryMemberAbleToUse()
        model.addAttribute("schoolList", schoolList)
        model.addAttribute("delegateList", delegateList)
        return "admin/AddGroup"
    }

    @Override
    String queryAllGroup(Model model) {
        List<Group> groupList = adminDao.queryAllGroup()
        model.addAttribute("groupList", groupList)
        return "admin/GroupList"
    }

    @Override
    String queryAllSchool(Model model) {
        List<School> schoolList = adminDao.queryAllSchool()
        model.addAttribute("schoolList", schoolList)
        return "admin/AllSchoolList"
    }

    @Override
    String queryGroupById(Model model, String id) {
        Group group = adminDao.queryGroupById(id)
        List<School> schoolList = adminDao.queryAllSchool()
        List<Delegate> delegateList = adminDao.queryMemberAbleToUse()
        model.addAttribute("groupInfo", group)
        model.addAttribute("schoolList", schoolList)
        model.addAttribute("delegateList", delegateList)
        return "admin/modifyGroup"
    }

    @Override
    String queryDelegateByGroupId(Model model, String groupID) {
        List<Delegate> delegateList = adminDao.queryDelegateByGroupId(Integer.parseInt(groupID))
        model.addAttribute("delegateList", delegateList)
        return "admin/GroupMemberList"
    }

    @Override
    String queryMemberByID(Model model, int id) {
        Delegate delegate = adminDao.queryMemberById(id)
        model.addAttribute("delegate", delegate)
        return "admin/MemberDetail"
    }

    @Override
    String queryAllSchoolType(Model model) {
        List<SchoolType> schoolTypeList = adminDao.queryAllSchoolType()
        model.addAttribute("schoolTypeList", schoolTypeList)
        return "admin/AddSchool"
    }

    @Override
    String queryAllSeat(Model model) {
        List<Seat> seatList = adminDao.queryAllSeat()
        model.addAttribute("seatList", seatList)
        return "admin/AllSeatList"
    }

    @Override
    List<JSONObject> getApplyStatusList() {
        List<ApplicationStatus> applicationStatusList = adminDao.queryAllApplicationStatus()
        List<JSONObject> jsonObjectList = new ArrayList<>()
        for (int n = 0; n < applicationStatusList.size(); n++) {
            jsonObjectList.add(new JSONObject())
        }
        for (int i = 0; i < applicationStatusList.size(); i++) {
            jsonObjectList[i].put("id", applicationStatusList[i].id)
            jsonObjectList[i].put("text", applicationStatusList[i].applicationStatusText)
        }
        return jsonObjectList
    }

    @Override
    String queryDelegateAndAdmin(Model model) {
        List<Admin> adminList = adminDao.queryAdminCanInterview()
        List<Delegate> delegateList = adminDao.queryDelegate()
        model.addAttribute("adminList", adminList)
        model.addAttribute("delegateList", delegateList)
        return "admin/AddInterview"
    }

    @Override
    String queryInterviewList(Model model, HttpSession session, String type) {
        User user = session.getAttribute("USER_INFO") as User
        int id = user.getId()
        switch (type) {
            case "all":
                List<Interview> interviewList = addNameIntoList(adminDao.queryAllInterview())
                model.addAttribute("interviewList", interviewList)
                break
            case "undone":
                List<Interview> interviewList = addNameIntoList(adminDao.queryInterviewUndone(false))
                model.addAttribute("interviewList", interviewList)
                break
            case "assignToMe":
                List<Interview> interviewList = addNameIntoList(adminDao.queryInterviewAssignToMe(id))
                model.addAttribute("interviewList", interviewList)
                break
            case "undoneByMe":
                List<Interview> interviewList = addNameIntoList(adminDao.queryInterviewAssignToMeDoneOrUndone(id, false))
                model.addAttribute("interviewList", interviewList)
                break
            case "doneByMe":
                List<Interview> interviewList = addNameIntoList(adminDao.queryInterviewAssignToMeDoneOrUndone(id, true))
                model.addAttribute("interviewList", interviewList)
                break
        }
        return "admin/AllInterviewList"
    }

    List<Interview> addNameIntoList(List<Interview> interviewList) {
        for (int i = 0; i < interviewList.size(); i++) {
            String delegateName = adminDao.getNameByID(interviewList[i].getId())
            interviewList[i].setDelegateName(delegateName)
            String adminName = adminDao.getNameByID(interviewList[i].getAdminID())
            interviewList[i].setAdminName(adminName)
        }
        return interviewList
    }

    @Override
    String queryInterviewByID(Model model, String id) {
        Interview interview = adminDao.queryInterviewByID(Integer.parseInt(id))
        interview.setDelegateName(adminDao.getNameByID(interview.getId()))
        interview.setAdminName(adminDao.getNameByID(interview.getAdminID()))
        model.addAttribute("interview", interview)
        return "admin/InterviewDetail"
    }

    @Override
    String queryBillList(Model model, String type) {
        switch (type) {
            case "all":
                List<Bill> billList = adminDao.queryAllBillList()
                model.addAttribute("billList", billList)
                break
            case "paid":
                List<Bill> billList = adminDao.queryBillList(true)
                model.addAttribute("billList", billList)
                break
            case "unpaid":
                List<Bill> billList = adminDao.queryBillList(false)
                model.addAttribute("billList", billList)
                break
            default:
                List<Bill> billList = adminDao.queryAllBillList()
                model.addAttribute("billList", billList)
                break
        }
        return "admin/AllBillList"
    }

    @Override
    String queryBillDetail(Model model, String id) {
        Bill bill = adminDao.queryBillDetail(Integer.parseInt(id))
        Delegate delegate = adminDao.queryMemberById(Integer.parseInt(id))
        model.addAttribute("bill", bill)
        model.addAttribute("delegate", delegate)
        return "admin/AdminBillDetail"
    }

    @Override
    String querySeatWaitProcess(Model model) {
        List<Seat> seatList=adminDao.allSeatWaitProcess()
        model.addAttribute("seatList",seatList)
        return "admin/AllSeatWaitProcess"
    }

    @Override
    String adminDetail(HttpSession httpSession, Model model, String id) {
        int ID=Integer.parseInt(id)
        Admin admin = adminDao.adminDetail(ID)
        model.addAttribute("admin",admin)
        return "admin/AdminDetail"
    }

    @Override
    String groupMemberDetail(Model model, String groupID) {
        int id=Integer.parseInt(groupID)
        List<Delegate> delegateList=adminDao.getGroupMember(id)
        model.addAttribute("delegateList",delegateList)
        return "admin/GroupMemberList"
    }
}
