package edu.dlufl.ohrigei.service.adminService.service

import com.alibaba.fastjson.JSONObject
import org.springframework.stereotype.Service

import javax.servlet.http.HttpServletRequest

@Service
interface AdminModifyService {
    JSONObject modifyGroup(int schoolID, Integer headDelegateID, int size, int GroupID)

    JSONObject modifyLoginStatus(HttpServletRequest request)

    JSONObject modifyApplicationStatus(HttpServletRequest request)

    JSONObject modifyInterviewScore(HttpServletRequest request)

    JSONObject modifyInterviewDate(HttpServletRequest request)

    JSONObject modifyInterviewStatus(HttpServletRequest request)

    JSONObject modifyInterviewComment(HttpServletRequest request)

    JSONObject confirmBill(HttpServletRequest request)

    JSONObject seatSelectConfirm(HttpServletRequest request)

    JSONObject passwordChange(HttpServletRequest request)
}