package com.webteckfianal.cab_booking.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webteckfianal.cab_booking.Repositories.CarRepository;
import com.webteckfianal.cab_booking.Repositories.UserRepository;
import com.webteckfianal.cab_booking.model.SignupUser;
import com.webteckfianal.cab_booking.model.regCar;

@Service
public class CabService {
    
    @Autowired
    private UserRepository userRepo;


    @Autowired
    private CarRepository carrepo;

    public void saveUser(SignupUser data){

        userRepo.save(data);
    }

    public void savecar(regCar car){

        carrepo.save(car);
    }

    public List<regCar> getCarList(){
        return carrepo.findAll();
        
    }

    public void deleteById(Long id){
        carrepo.deleteById(id);
    }

    public regCar getCarById(Long id){
        return carrepo.findById(id).get();
    }


}
