package edu.dlufl.ohrigei.service.adminService.impl

import com.alibaba.fastjson.JSONObject
import edu.dlufl.ohrigei.dao.AdminDao
import edu.dlufl.ohrigei.dao.UserDao
import edu.dlufl.ohrigei.service.adminService.service.AdminModifyService
import edu.dlufl.ohrigei.util.UtilSet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

import javax.servlet.http.HttpServletRequest

@Service("AdminModifyService")
class AdminModifyServiceImpl implements AdminModifyService {
    @Autowired
    AdminDao adminDao
    @Autowired
    UserDao userDao
    @Override
    JSONObject modifyGroup(int schoolID, Integer headDelegateID, int size, int groupID) {
        JSONObject jsonObject = new JSONObject()
        try {
            adminDao.modifyGroup(schoolID, headDelegateID, size, groupID)
            jsonObject.put("status", "SUCCESS")
        }
        catch (Exception ignored) {
            jsonObject.put("status", "ERROR")
        }
        return jsonObject
    }

    @Override
    JSONObject modifyLoginStatus(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject()
        int userID = request.getParameter("userID") as int
        boolean loginStatus = Boolean.parseBoolean(request.getParameter("LoginStatus"))
        if (loginStatus) {
            try {
                adminDao.modifyLoginStatusById(userID, false)
                jsonObject.put("status", "SUCCESS")
            }
            catch (Exception ignored) {
                jsonObject.put("status", "ERROR")
            }
        } else if (!loginStatus) {
            try {
                adminDao.modifyLoginStatusById(userID, true)
                jsonObject.put("status", "SUCCESS")
            }
            catch (Exception ignored) {
                jsonObject.put("status", "ERROR")
            }
        }
        return jsonObject
    }

    @Override
    JSONObject modifyApplicationStatus(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject()
        int id = request.getParameter("id") as int
        int applicationID = request.getParameter("applicationStatus") as int
        try {
            adminDao.modifyApplicationStatus(id, applicationID)
            jsonObject.put("status", "SUCCESS")
        }
        catch (Exception ignored) {
            jsonObject.put("status", "ERROR")
        }
        return jsonObject
    }

    @Override
    JSONObject modifyInterviewScore(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject()
        int id = request.getParameter("id") as int
        int academicScore = request.getParameter("academicScore") as int
        int passionScore = request.getParameter("passionScore") as int
        float totalScore = request.getParameter("totalScore") as float
        try {
            adminDao.modifyInterviewScore(id, academicScore, passionScore, totalScore)
            jsonObject.put("status", "SUCCESS")
            jsonObject.put("academicScore", academicScore)
            jsonObject.put("passionScore", passionScore)
            jsonObject.put("totalScore", totalScore)
        }
        catch (Exception ignored) {
            jsonObject.put("status", "ERROR")
        }
        return jsonObject
    }

    @Override
    JSONObject modifyInterviewDate(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject()
        int id = request.getParameter('id') as int
        String date = request.getParameter('newInterviewDate')
        try {
            adminDao.modifyInterviewDate(id, date)
            jsonObject.put("status", "SUCCESS")
            jsonObject.put("date", date.replace("T", " "))
        }
        catch (Exception ignored) {
            jsonObject.put("status", "ERROR")
        }
        return jsonObject
    }

    @Override
    JSONObject modifyInterviewStatus(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject()
        int id = request.getParameter("id") as int
        String interviewStatus = request.getParameter("interviewStatus")
        if (interviewStatus == "pass") {
            try {
                adminDao.modifyInterviewStatus(id, true)
                adminDao.modifyUserStatus(id, 5)
                if (adminDao.creatBillCheck(id) != 0) {
                    adminDao.creatNewBill(id, adminDao.getRoleIDByID(id), UtilSet.getCurrentTime(), false)
                }
                jsonObject.put("status", "SUCCESS")
                jsonObject.put("interviewStatus", "已完成")
            }
            catch (Exception ignored) {
                jsonObject.put("status", "ERROR")
            }
        } else {
            try {
                adminDao.modifyInterviewStatus(id, true)
                adminDao.modifyUserStatus(id, 4)
                jsonObject.put("status", "SUCCESS")
                jsonObject.put("interviewStatus", "已完成")
            }
            catch (Exception ignored) {
                jsonObject.put("status", "ERROR")
            }
        }
        return jsonObject
    }

    @Override
    JSONObject modifyInterviewComment(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject()
        int id = request.getParameter("id") as int
        String comment = request.getParameter("comment")
        try {
            adminDao.modifyInterviewComment(id, comment)
            jsonObject.put("status", "SUCCESS")
            jsonObject.put("comment", comment)
        }
        catch (Exception ignored) {
            jsonObject.put("status", "ERROR")
        }
        return jsonObject
    }

    @Override
    JSONObject confirmBill(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject()
        int id = Integer.parseInt(request.getParameter("id"))
        try {
            adminDao.confirmBill(id)
            adminDao.modifyUserStatus(id, 7)
            jsonObject.put("status", "SUCCESS")
            jsonObject.put("confirm", "已支付")
        }
        catch (Exception ignored) {
            jsonObject.put("status", "ERROR")
        }
        return jsonObject
    }

    @Override
    JSONObject seatSelectConfirm(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject()
        int seatID = request.getParameter("seatID") as int
        int delegateID = request.getParameter("delegateID") as int
        try {
            adminDao.seatSelectConfirm(seatID)
            adminDao.updateUserApplicationStatus(delegateID,10)
            jsonObject.put("status","SUCCESS")
        }
        catch (Exception ignored){
            jsonObject.put("status","ERROR")
        }
        return jsonObject
    }

    @Override
    JSONObject passwordChange(HttpServletRequest request) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder()
        JSONObject jsonObject = new JSONObject()
        int delegateID = request.getParameter("id") as int
        String passwordDB = userDao.getPasswordByID(delegateID)
        String passwordOld = request.getParameter("passwordOld")
        if (encoder.matches(passwordOld, passwordDB)) {
            String passwordNew = new BCryptPasswordEncoder().encode(request.getParameter("passwordNew"))
            try {
                userDao.changePasswordByID(delegateID, passwordNew)
                jsonObject.put("status", "SUCCESS")
            }
            catch (Exception ignored) {
                jsonObject.put("status", "ERROR")
                jsonObject.put("info", "修改密码发生错误，请稍后再试")
            }
        } else {
            jsonObject.put('status', 'ERROR')
            jsonObject.put('info', '原密码错误，请重新输入')
        }
        return jsonObject
    }
}
