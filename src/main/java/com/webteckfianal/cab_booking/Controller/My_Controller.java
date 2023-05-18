package com.webteckfianal.cab_booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import com.webteckfianal.cab_booking.Repositories.LoginRepository;
import com.webteckfianal.cab_booking.Repositories.carSatusrepo;
import com.webteckfianal.cab_booking.Services.CabService;
import com.webteckfianal.cab_booking.model.SignupUser;
import com.webteckfianal.cab_booking.model.regCar;


import jakarta.servlet.http.HttpSession;

@Controller
public class My_Controller {

    @Autowired
    private CabService service;

    @Autowired
    private LoginRepository loginRepo;

    @Autowired
    private carSatusrepo statusrepo;

    


    
    /////////////////////// linking pages////////////////////////

    @GetMapping("/")
    public String landingPage(){
        return "landingPage";
    }
    @GetMapping("/registerPage")
    public String signupfrom(){
        return "signup";
    }
   
    @GetMapping("/login")
    public String loginform(){
        return "login";
    }

   

    @GetMapping("/registerCar")
    public String registerCar(){
        return "registerCar";
    }

    
    @GetMapping("/booked")
    public String booked(Model model){
        regCar Available = statusrepo.findBystatus("not available");
        model.addAttribute("regCar", Available);
        return "booked";
    }

       

    @GetMapping("/normalUserPage")
    public String  userpage(Model model){
        // List<regCar> data = service.getCarList();
        regCar notAvailable = statusrepo.findBystatus("available");
        model.addAttribute("normalUserPage", notAvailable);
        return "userPage";
        
    }
  
    


/////////////////////////logics/////////////////

    @PostMapping("/regUser")
    public String UserRegister(@ModelAttribute SignupUser user){
        String role ="normal";
        user.setRole(role);
        service.saveUser(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String logUserIn(@RequestParam("username") String name, @RequestParam("password") String password, HttpSession session){
        String role ="normal";
        String admin ="admin";
        SignupUser userData = loginRepo.findByusername(name);
        if(userData !=null && userData.getRole().equals(admin) && userData.getUsername().equals(name) && userData.getPassword().equals(password)){
            session.setAttribute("name", name);
            return "redirect:/dashhboard";

        }else if(userData !=null && userData.getRole().equals(role)  && userData.getUsername().equals(name) && userData.getPassword().equals(password)){
            return "redirect:/normalUserPage";
        }else{
            return "redirect:/ooops";
        }
    
    }

    @PostMapping("/regCar")
    public String carRegister(@ModelAttribute regCar car){
      String status ="available";
      car.setStatus(status);
        service.savecar(car);
        return "redirect:/dashhboard";
    }

    @GetMapping("/dashhboard")
    public ModelAndView dashboard(){
        List<regCar> list =service.getCarList();

        return new ModelAndView("dashboard", "regCar", list);
    }

    

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
        return "redirect:/dashhboard";
    }

    @RequestMapping("/update/{id}")
    public String editCarById(@PathVariable("id") Long id, Model model){
        regCar cardata = service.getCarById(id);
        model.addAttribute("cardata",cardata);
      

        return "carEdit";
    }
@GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
    
    
    @RequestMapping("/book/{id}")
    public String bookBYId(@PathVariable("id") Long id){
        regCar data = service.getCarById(id);
        String status ="not available";
        data.setStatus(status);
        service.savecar(data);
       

        return "redirect:/normalUserPage";
    }

    @GetMapping("/ooops")
    public String oops(){
      
        return "ooops";
    }



}
