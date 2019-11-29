package edu.dlufl.ohrigei.service.userService.service;

import edu.dlufl.ohrigei.model.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

@Service
public interface UserService {
    String loginCheck(User user, HttpSession session, Model model);

    boolean authorityCheck(String email);
}
