package edu.dlufl.ohrigei.service.adminService.impl

import com.alibaba.fastjson.JSONObject
import edu.dlufl.ohrigei.dao.AdminDao
import edu.dlufl.ohrigei.service.adminService.service.AdminDeleteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.servlet.http.HttpServletRequest

@Service("AdminDeleteService")
class AdminDeleteServiceImpl implements AdminDeleteService{
    @Autowired
    AdminDao adminDao
    @Override
    JSONObject deleteGroup(int groupID) {
        JSONObject jsonObject = new JSONObject()
        try {
            adminDao.deleteGroup(groupID)
            adminDao.deleteGroupIDFromDelegate(groupID)
            jsonObject.put("status", "SUCCESS")
        } catch (Exception ignored){
            jsonObject.put("status", "ERROR")
        }
        return jsonObject
    }

    @Override
    JSONObject deletePost(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject()
        int id=request.getParameter("postID") as int
        try {
            adminDao.deletePost(id)
            jsonObject.put("status", "SUCCESS")
        } catch (Exception ignored){
            jsonObject.put("status", "ERROR")
        }
        return jsonObject
    }

    @Override
    JSONObject removeDelegateFromGroup(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject()
        int id=request.getParameter("delegateID") as int
        try {
            adminDao.removeDelegateFromGroup(id)
            jsonObject.put("status", "SUCCESS")
        } catch (Exception ignored){
            jsonObject.put("status", "ERROR")
        }
        return jsonObject
    }
}
