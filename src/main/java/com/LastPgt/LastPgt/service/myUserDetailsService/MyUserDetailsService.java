package com.LastPgt.LastPgt.service.myUserDetailsService;

import com.LastPgt.LastPgt.model.MyUserDetails;
import java.util.List;
import java.util.Optional;

public interface MyUserDetailsService {
    List<MyUserDetails> findAllUserDetails();
    Optional<MyUserDetails> findUserDetailsById(Long id);
    MyUserDetails saveUserDetails(MyUserDetails myUserDetails);
    void deleteUserDetails(Long id);
}
