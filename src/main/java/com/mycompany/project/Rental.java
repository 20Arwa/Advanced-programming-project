/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Norh
 */
@Entity 
@Table (name="Rental")
public class Rental  implements java.io.Serializable { 
 
     @Id 
     @Column(name="Id") 
     private int Id;
     
     @Column(name="Duration") 
     private String Duration; 
     
     
     
     @Column(name="Total_cost") 
     private double Total_cost;
     
     
//     @ManyToOne
    @Column(name = "car_id")
    private int car;

//    @ManyToOne
    @Column(name = "phone_number")
    private String user;

    
    public Rental() {
        
    }


   public Rental(int id,String duration, double total,String phone,int carID) {
       this.Id = id;
       this.Duration = duration;
       this.Total_cost = total;
       this.user = phone;
       this.car = carID;
    }
   
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    public double getTotal_cost() {
        return Total_cost;
    }

    public void setTotal_cost(double Total_cost) {
        this.Total_cost = Total_cost;
    }

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
     
     
 
 
    

    
}