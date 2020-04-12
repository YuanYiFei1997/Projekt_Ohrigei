package edu.dlufl.ohrigei.service.adminService.service

import com.alibaba.fastjson.JSONObject
import edu.dlufl.ohrigei.model.Committee
import edu.dlufl.ohrigei.model.Group
import org.springframework.stereotype.Service
import org.springframework.ui.Model

import javax.servlet.http.HttpSession

@Service
interface AdminQueryService {
    String queryMembers(HttpSession session, Model model, String act)
    String  queryAdmin(HttpSession session ,Model model)
    List<Group> queryGroup(HttpSession session ,Model model)
    List<Committee> queryCommittee(HttpSession session,Model model)
    String queryAllDelegateAndSchool(Model model)
    String queryAllGroup(Model model)
    String queryAllSchool(Model model)
    String queryAllSeat(Model model)
    String queryGroupById(Model model,String id)
    String queryDelegateByGroupId(Model model,String groupID)
    String queryMemberByID(Model model,int id)
    String queryAllSchoolType(Model model)
    String queryAdminIDAndName(Model model)
    String queryAllCommittee(Model model)
    String queryCommitteeIDAndName(Model model)
    List<JSONObject> getApplyStatusList()
    String queryDelegateAndAdmin(Model model)
    String queryInterviewList(Model model,HttpSession session,String type)
    String queryInterviewByID(Model model,String id)
    String queryBillList(Model model,String type)
    String queryBillDetail(Model model,String id)
    String querySeatWaitProcess(Model model)
    String adminDetail(HttpSession httpSession, Model model,String id)
    String groupMemberDetail(Model model,String groupID)
}