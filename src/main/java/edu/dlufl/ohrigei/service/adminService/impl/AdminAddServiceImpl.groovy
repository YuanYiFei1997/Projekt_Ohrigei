package edu.dlufl.ohrigei.service.adminService.impl

import com.alibaba.fastjson.JSONObject
import edu.dlufl.ohrigei.dao.AdminDao
import edu.dlufl.ohrigei.model.Admin
import edu.dlufl.ohrigei.service.adminService.service.AdminAddService
import edu.dlufl.ohrigei.util.Base64ToFile
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

import javax.servlet.http.HttpServletRequest
import java.text.SimpleDateFormat

@Service("AdminAddService")
class AdminAddServiceImpl implements AdminAddService {
    @Autowired
    AdminDao adminDao

    @Override
    JSONObject addSchool(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject()
        String schoolName = request.getParameter("schoolName")
        String schoolNameEN = request.getParameter("schoolNameEN")
        String schoolAddress = request.getParameter("schoolAddress")
        int schoolTypeID = request.getParameter("schoolType") as int
        int schoolSize = request.getParameter("schoolSize") as int
        try {
            adminDao.addSchool(schoolName, schoolNameEN, schoolAddress, schoolTypeID, schoolSize)
            jsonObject.put("status", "SUCCESS")
        }
        catch (Exception ignored) {
            jsonObject.put("status", "ERROR")
        }
        return jsonObject
    }

    @Override
    JSONObject addCommittee(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject()
        String committeeName = request.getParameter("committeeName")
        int seatWidth = request.getParameter("seatWidth") as int
        int chairmanID = request.getParameter("chairmanID") as int
        try {
            adminDao.addCommittee(committeeName, seatWidth, chairmanID)
            jsonObject.put("status", "SUCCESS")
            return jsonObject
        }
        catch (Exception ignored) {
            jsonObject.put("status", "ERROR")
            return jsonObject
        }
    }

    JSONObject addAdmin(HttpServletRequest request) throws UsernameNotFoundException {
        JSONObject jsonObject = new JSONObject()
        String adminName = request.getParameter("adminName")
        String adminPhone = request.getParameter("adminPhone")
        String adminEmail = request.getParameter("adminEmail")
        String adminPassword = new BCryptPasswordEncoder().encode(request.getParameter("adminPassword"))
        String adminTitle = request.getParameter("adminTitle")
        Boolean role_AG = Boolean.parseBoolean(request.getParameter("role_AG"))
        Boolean role_AD = Boolean.parseBoolean(request.getParameter("role_AD"))
        Boolean role_D = Boolean.parseBoolean(request.getParameter("role_D"))
        Boolean role_SG = Boolean.parseBoolean(request.getParameter("role_SG"))
        Boolean role_F = Boolean.parseBoolean(request.getParameter("role_F"))
        Boolean role_L = Boolean.parseBoolean(request.getParameter("role_L"))
        if (adminDao.emailCheck(adminEmail) != null) {
            jsonObject.put("status", "ERROR")
            jsonObject.put("errorText", "邮箱已被使用")
            return jsonObject
        }
        Admin admin = new Admin()
        admin.setName(adminName)
        admin.setEmail(adminEmail)
        admin.setPhone(adminPhone)
        admin.setPassword(adminPassword)
        admin.setTitle(adminTitle)
        admin.setRole_AG(role_AG)
        admin.setRole_AD(role_AD)
        admin.setRole_D(role_D)
        admin.setRole_SG(role_SG)
        admin.setRole_F(role_F)
        admin.setRole_L(role_L)
        try {
            adminDao.addAdminStep1(admin)
            admin.setId(adminDao.getInsertID(admin.getEmail()))
            adminDao.addAdminStep2(admin)
            jsonObject.put("status", "SUCCESS")
        }
        catch (Exception ignored) {
            jsonObject.put("status", "ERROR")
            jsonObject.put("errorText", ignored)
        }
        return jsonObject
    }

    @Override
    JSONObject addGroup(int schoolID, Integer headDelegateID, int size) {
        JSONObject object = new JSONObject()
        try {
            adminDao.addGroup(schoolID, headDelegateID, size)
            object.put("status", "SUCCESS")
        }
        catch (Exception ignored) {
            object.put("status", "ERROR")
        }
        return object
    }

    @Override
    JSONObject addSeat(HttpServletRequest request) {
        /**
         * 'seatName':seatName,
         * 'committeeID':committeeID,
         * 'seatDifficulty':seatDifficulty
         */
        JSONObject jsonObject=new JSONObject()
        String seatName =request.getParameter("seatName")
        int committeeID=request.getParameter("committeeID")as int
        int seatDifficulty=request.getParameter("seatDifficulty")as int
        int committeeSeatWidth=adminDao.committeeWidthSizeGet(committeeID)
        int seatCount=adminDao.countSeatByCommitteeID(committeeID)
        if (seatCount<committeeSeatWidth){
            try {
                adminDao.addSeat(seatName,committeeID,seatDifficulty)
                jsonObject.put("status","SUCCESS")
            }
            catch (Exception ignored){
                jsonObject.put("status","ERROR")
                jsonObject.put("errorText","添加失败")
            }
        }else {
            jsonObject.put("status","ERROR")
            jsonObject.put("errorText","委员会席位已满")
        }

        return jsonObject
    }

    @Override
    JSONObject addInterview(HttpServletRequest request) {
        JSONObject jsonObject=new JSONObject()
        SimpleDateFormat dateFormat=new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss"))
        String dateData=request.getParameter("interviewDate").replace("T"," ")
        int delegateID=request.getParameter("delegateID") as int
        int adminID=request.getParameter("adminID") as int
        Date date = dateFormat.parse(dateData)
        try {
            adminDao.addInterview(delegateID,adminID,date)
            jsonObject.put("status","SUCCESS")
        }
        catch (Exception ignored){
            jsonObject.put("status","ERROR")
        }
        return jsonObject
    }

    @Override
    JSONObject addPost(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject()
        String post=request.getParameter("post")
        try {
            adminDao.addPost(post)
            jsonObject.put("status","SUCCESS")
        }
        catch (Exception ignored){
            jsonObject.put("status","ERROR")
        }
        return jsonObject
    }

    @Override
    JSONObject addImg(HttpServletRequest request) {
        String base64=request.getParameter("imgData")
        int id=request.getParameter("id") as int
        JSONObject jsonObject = Base64ToFile.base64ToFile(base64, id)
        return jsonObject
    }
}
