package com.LastPgt.LastPgt.service.userService;

import com.LastPgt.LastPgt.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    Optional<User> findUserById(Long id);
    Optional<User> findUserByUsername(String username);
    User saveUser(User user);
    void deleteUser(Long id);
}
