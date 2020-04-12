package edu.dlufl.ohrigei.service.adminService.service

import com.alibaba.fastjson.JSONObject
import org.springframework.stereotype.Service

import javax.servlet.http.HttpServletRequest

@Service
interface AdminDeleteService {
    JSONObject deleteGroup(int GroupID)
    JSONObject deletePost(HttpServletRequest request)
    JSONObject removeDelegateFromGroup(HttpServletRequest request)
}
