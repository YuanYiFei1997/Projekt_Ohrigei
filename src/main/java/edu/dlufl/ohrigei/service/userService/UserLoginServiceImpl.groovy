package edu.dlufl.ohrigei.service.userService

import edu.dlufl.ohrigei.dao.UserDao
import edu.dlufl.ohrigei.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("UserLoginService")
class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    UserDao userDao;

    User getUser(short id) {
        return userDao.findById(id);
    }

    @Override
    boolean loginCheck(String email, String inputPassword) {
        String password = userDao.loginCheck(email)
        boolean compare
        compare = password == inputPassword;
        return compare
    }
}
