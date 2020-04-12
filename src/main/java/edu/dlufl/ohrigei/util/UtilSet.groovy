package edu.dlufl.ohrigei.util

import edu.dlufl.ohrigei.dao.UserDao
import org.springframework.beans.factory.annotation.Autowired

import java.text.SimpleDateFormat

class UtilSet {
    @Autowired
    static UserDao userDao

    static String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = simpleDateFormat.format(new Date())
        return currentTime
    }

    static String userValidate() {
        userDao.getDelegateInfo()
        return null
    }
}
