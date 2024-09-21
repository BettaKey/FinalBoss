package com.LastPgt.LastPgt.service.myUserDetailsService;

import com.LastPgt.LastPgt.model.MyUserDetails;
import com.LastPgt.LastPgt.repository.MyUserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsServiceImpl implements MyUserDetailsService {
    private final MyUserDetailsRepository myUserDetailsRepository;

    @Autowired
    public MyUserDetailsServiceImpl(MyUserDetailsRepository myUserDetailsRepository) {
        this.myUserDetailsRepository = myUserDetailsRepository;
    }

    @Override
    public List<MyUserDetails> findAllUserDetails() {
        return myUserDetailsRepository.findAll();
    }

    @Override
    public Optional<MyUserDetails> findUserDetailsById(Long id) {
        return myUserDetailsRepository.findById(id);
    }

    @Override
    public MyUserDetails saveUserDetails(MyUserDetails myUserDetails) {
        return myUserDetailsRepository.save(myUserDetails);
    }

    @Override
    public void deleteUserDetails(Long id) {
        myUserDetailsRepository.deleteById(id);
    }
}
