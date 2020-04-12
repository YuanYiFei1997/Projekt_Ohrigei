package edu.dlufl.ohrigei.service.adminService.service

import com.alibaba.fastjson.JSONObject
import org.springframework.stereotype.Service

import javax.servlet.http.HttpServletRequest

@Service
interface AdminAddService {
    JSONObject addAdmin(HttpServletRequest request)

    JSONObject addGroup(int schoolID, Integer headDelegateID, int size)

    JSONObject addSchool(HttpServletRequest request)

    JSONObject addCommittee(HttpServletRequest request)

    JSONObject addSeat(HttpServletRequest request)

    JSONObject addInterview(HttpServletRequest request)

    JSONObject addPost(HttpServletRequest request)

    JSONObject addImg(HttpServletRequest request)
}