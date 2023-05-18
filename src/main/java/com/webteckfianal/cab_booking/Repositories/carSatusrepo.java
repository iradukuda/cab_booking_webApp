package com.webteckfianal.cab_booking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webteckfianal.cab_booking.model.regCar;

@Repository
public interface carSatusrepo extends JpaRepository<regCar, Long> {

    regCar findBystatus(String status);
    
}
