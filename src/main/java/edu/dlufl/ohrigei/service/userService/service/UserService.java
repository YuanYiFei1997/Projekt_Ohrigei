package edu.dlufl.ohrigei.service.userService.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean loginCheck(String email,String password);
    boolean authorityCheck(String email);
}
