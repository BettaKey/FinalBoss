package com.LastPgt.LastPgt.repository;

import com.LastPgt.LastPgt.model.MyUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserDetailsRepository extends JpaRepository<MyUserDetails, Long> {
}
