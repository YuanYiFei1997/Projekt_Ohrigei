package edu.dlufl.ohrigei.controller.userController

import com.alibaba.fastjson.JSONObject
import edu.dlufl.ohrigei.dao.UserDao
import edu.dlufl.ohrigei.service.userService.service.UserService
import edu.dlufl.ohrigei.util.UtilSet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/user")
class UserRestController {
    @Autowired
    UserService userService
    @Autowired
    UserDao userDao

    @PostMapping("/modifyPayDetail")
    JSONObject modifyPayDetail(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject()
        int id = Integer.parseInt(request.getParameter("id"))
        String billSerialNumber = request.getParameter("billSerialNumber")
        String billPayDate = request.getParameter("billPayDate")
        if (billPayDate != null) {
            billPayDate.replace("T", " ")
        } else {
            billPayDate = UtilSet.getCurrentTime()
        }
        try {
            userDao.modifyPayDetail(id, billSerialNumber, billPayDate)
            jsonObject.put("status", "SUCCESS")
        }
        catch (Exception ignored) {
            jsonObject.put("status", "ERROR")
        }
        return jsonObject
    }

    @PostMapping("/selectSeat")
    JSONObject selectSeat(HttpServletRequest request) {
        return userService.userSelectSeat(request)
    }

    @PostMapping("/userSelectGroup")
    JSONObject selectGroup(HttpServletRequest request) {
        return userService.userSelectGroup(request)
    }

    @PostMapping("/leaveFromConference")
    JSONObject leaveFromConference(HttpServletRequest request) {
        return userService.leaveFromConference(request)
    }

    @PostMapping("/leaveGroup")
    JSONObject leaveGroup(HttpServletRequest request) {
        return userService.leaveGroup(request)
    }

    @PostMapping("/passwordChange")
    JSONObject passwordChange(HttpServletRequest request) {
        return userService.passwordChange(request)
    }

    @PostMapping("/uploadImg")
    JSONObject imgUpload(HttpServletRequest request) {
        return userService.addImg(request)
    }
}
