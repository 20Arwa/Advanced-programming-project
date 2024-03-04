/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Norh
 */
@Entity 
@Table (name="Car")
public class Car  implements java.io.Serializable { 
 
     @Id 
     @Column(name="Car_id") 
     private int Car_id;
     
     @Column(name="Category") 
     private String Category; 
     
     
     @Column(name="Color") 
     private String Color; 
     
     @Column(name="Name_car") 
     private String Name_car; 

    public String getName_car() {
        return Name_car;
    }

    public void setName_car(String Name_car) {
        this.Name_car = Name_car;
    }
     
     
 
    public Car() { 
    } 
 
 
    public Car(int car_id, String category,String color) { 
        
       this.Car_id = car_id; 
       this.Category = category;
       this.Color = color;
    } 

    public int getCar_id() {
        return Car_id;
    }

    public void setCar_id(int Car_id) {
        this.Car_id = Car_id;
    }

    public String getCartegory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    } 
}
