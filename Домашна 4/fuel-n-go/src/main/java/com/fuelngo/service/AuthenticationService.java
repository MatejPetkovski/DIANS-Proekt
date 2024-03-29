package com.fuelngo.service;

import com.fuelngo.model.Role;
import com.fuelngo.model.User;

import java.util.Optional;

public interface AuthenticationService {

    User register(String email_address, String username, String password, String repeatPassword, Role role);

    User login(String username,String password);

}
