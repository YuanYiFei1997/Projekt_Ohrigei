package edu.dlufl.ohrigei.service.adminService.service


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
}