package com.webteckfianal.cab_booking.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
public class regCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long car_id;
    private String car_model;
    private String car_make;
    @DateTimeFormat(pattern ="yyyy/MM/dd")
    private LocalDate car_year;
    private String car_color;
    private String status;
    

    public regCar() {
    }
    public Long getCar_id() {
        return car_id;
    }
    public void setCar_id(Long car_id) {
        this.car_id = car_id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCar_model() {
        return car_model;
    }
    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }
    public String getCar_make() {
        return car_make;
    }
    public void setCar_make(String car_make) {
        this.car_make = car_make;
    }
    public LocalDate getCar_year() {
        return car_year;
    }
    public void setCar_year(LocalDate car_year) {
        this.car_year = car_year;
    }
    public String getCar_color() {
        return car_color;
    }
    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }



}
