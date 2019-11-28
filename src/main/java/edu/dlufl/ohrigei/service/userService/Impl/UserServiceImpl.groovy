package edu.dlufl.ohrigei.service.userService.Impl

import edu.dlufl.ohrigei.dao.UserDao
import edu.dlufl.ohrigei.model.User
import edu.dlufl.ohrigei.service.userService.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("UserLoginService")
class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    User getUser(short id) {
        return userDao.findById(id);
    }

    @Override
    boolean loginCheck(String email, String inputPassword) {
        String password = userDao.loginCheck(email)
        return password == inputPassword
    }

    @Override
    boolean authorityCheck(String email) {
        int userType
        userType = userDao.authorityControl(email)
        return userType == 0
    }
}
