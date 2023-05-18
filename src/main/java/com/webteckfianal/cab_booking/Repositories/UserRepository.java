package com.webteckfianal.cab_booking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webteckfianal.cab_booking.model.SignupUser;
@Repository
public interface UserRepository extends JpaRepository <SignupUser, Long> {
    
}
