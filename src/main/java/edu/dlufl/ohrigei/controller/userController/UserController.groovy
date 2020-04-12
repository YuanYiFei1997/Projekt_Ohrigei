package edu.dlufl.ohrigei.controller.userController

import edu.dlufl.ohrigei.dao.AdminDao
import edu.dlufl.ohrigei.dao.UserDao
import edu.dlufl.ohrigei.model.Delegate
import edu.dlufl.ohrigei.model.Post
import edu.dlufl.ohrigei.model.User
import edu.dlufl.ohrigei.service.userService.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import javax.servlet.http.HttpSession
/**
 * @author yifei.yuan
 */
@Controller
@RequestMapping("/user")
class UserController {
    @Autowired
    UserService userService
    @Autowired
    UserDao userDao;
    @Autowired
    AdminDao adminDao;
    @RequestMapping("/index")
    String toIndex(Model model, Authentication authentication, HttpSession session) {
        User user = userDao.getUserByEmail(authentication.getName());
        Delegate userInfo = userDao.getDelegateInfo(user.getId());
        String description = userDao.getDescription(userInfo.getApplicationStatusID())
        List<Post> postList = adminDao.getPost()
        model.addAttribute("description", description)
        model.addAttribute("delegateInfo", userInfo)
        session.setAttribute("USER_INFO", user)
        model.addAttribute("postList",postList)
        return "/user/UserIndex";
    }


    @RequestMapping("/userProfile")
    String userProfile(Model model, String id) {
        return userService.userProfile(model, id)
    }

    @RequestMapping("/userInterviewDetail")
    String userInterviewDetail(Model model, String id, HttpSession session) {
        return userService.userInterviewDetail(model, id, session)
    }

    @RequestMapping("/userBillDetail")
    String userBillDetail(Model model, String id, HttpSession session) {
        return userService.userBillDetail(model, id, session)
    }

    @RequestMapping("/userSeatDetail")
    String userSeatDetail(Model model, String id, HttpSession session) {
        return userService.userSeatDetail(model, id, session)
    }

    @RequestMapping("/userGroupDetail")
    String userGroupDetail(Model model, String id, HttpSession session) {
        return userService.userGroupDetail(model,id,session)
    }
}