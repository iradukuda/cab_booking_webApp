package com.webteckfianal.cab_booking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webteckfianal.cab_booking.model.SignupUser;

public interface LoginRepository extends JpaRepository<SignupUser, Long> {
    
    SignupUser findByusername(String name);
}
