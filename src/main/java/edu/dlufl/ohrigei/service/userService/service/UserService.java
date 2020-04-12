package edu.dlufl.ohrigei.service.userService.service;

import com.alibaba.fastjson.JSONObject;
import edu.dlufl.ohrigei.model.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public interface UserService {
    String userSignUp(User user,Model model);
    String userProfile(Model model,String id);
    String userInterviewDetail(Model model, String id, HttpSession session);
    String userBillDetail(Model model,String id,HttpSession session);
    String userSeatDetail(Model model,String id,HttpSession session);
    JSONObject userSelectSeat(HttpServletRequest request);
    String userGroupDetail(Model model,String id,HttpSession session);
    JSONObject userSelectGroup(HttpServletRequest request);
    JSONObject leaveFromConference(HttpServletRequest request);
    JSONObject leaveGroup(HttpServletRequest request);
    JSONObject passwordChange(HttpServletRequest request);
    JSONObject addImg(HttpServletRequest request);
}
