package edu.dlufl.ohrigei.dao

import edu.dlufl.ohrigei.model.User
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository

@Repository
interface UserDao {
    User findById(@Param("id") short id)
    //密码校验
    User loginCheck(User user)
    //区分用户类型
    int authorityControl(String email)
}