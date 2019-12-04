package edu.dlufl.ohrigei.service.userService.Impl

import edu.dlufl.ohrigei.dao.UserDao
import edu.dlufl.ohrigei.model.User
import edu.dlufl.ohrigei.service.userService.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.ui.Model

import javax.servlet.http.HttpSession

@Service("UserLoginService")
class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    User getUser(short id) {
        return userDao.findById(id);
    }

    @Override
    String loginCheck(User user, HttpSession session, Model model) {
        User user1 = userDao.loginCheck(user)
        if (user1 != null) {
            user.setEmail(user1.getEmail())
            user.setName(user1.getName())
            user.setId(user1.getId())
            session.setAttribute("user", user)
            if (user1.getType() == 0)
                return "redirect:/admin/dashBoard"
            else return "/user/UserIndex"
        }
        model.addAttribute("errorMessage","用户名或密码错误")
        return "forward:/"
    }

    @Override
    String userSignUp(User user, Model model) {
        String emailCheck=userDao.userEmailCheck(user.getEmail())
        if (emailCheck!=null){
            model.addAttribute("errormessage","电子邮箱重复")
            return "forward:/SignUp"
        }else {
            userDao.userSignUp(user)
            return "forward:/"
        }
    }

    @Override
    boolean authorityCheck(String email) {
        int userType
        userType = userDao.authorityControl(email)
        return userType == 0
    }
}
