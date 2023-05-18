package com.webteckfianal.cab_booking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webteckfianal.cab_booking.model.regCar;

public interface CarRepository extends JpaRepository<regCar, Long> {
    
}
