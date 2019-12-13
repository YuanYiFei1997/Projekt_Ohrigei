package edu.dlufl.ohrigei.service.userService.Impl

import edu.dlufl.ohrigei.dao.UserDao
import edu.dlufl.ohrigei.model.User
import edu.dlufl.ohrigei.service.userService.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.LockedException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.ui.Model

@Service("UserService")
class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserDao userDao
    @Override
    String userSignUp(User user, Model model) {
        String emailCheck = userDao.userEmailCheck(user.getEmail())
        if (emailCheck != null) {
            model.addAttribute("errorMessage", "电子邮箱重复")
            return "/user/UserSignUp"
        } else {
            String password=new BCryptPasswordEncoder().encode(user.getPassword())
            String upCaseFirstName = user.getFirst_name().toUpperCase()
            String upCaseLastName = user.getLast_name().toUpperCase()
            user.setFirst_name(upCaseFirstName)
            user.setLast_name(upCaseLastName)
            user.setPassword(password)
            userDao.userSignUp(user)
            userDao.insertDelegate(user)
            return "login"
        }
    }
    @Override
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.login(email)
        if (user == null)
            throw new UsernameNotFoundException("用户不存在")
        else if (!user.getEnable_Login()){
            throw new LockedException("账户不可用")
        }
        return user
    }
}
