package edu.dlufl.ohrigei.service.userService;

import edu.dlufl.ohrigei.model.User;

public interface UserLoginService {
    User getUser(short id);
    boolean loginCheck(String email,String password);
}
