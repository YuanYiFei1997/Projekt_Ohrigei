package edu.dlufl.ohrigei.service.userService.service;

import edu.dlufl.ohrigei.model.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface UserService {
    String userSignUp(User user,Model model);
}
