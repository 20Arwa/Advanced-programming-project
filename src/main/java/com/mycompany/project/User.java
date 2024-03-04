/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author lap12
 */
@Entity
@Table (name="User")
public class User implements java.io.Serializable {
    @Column(name="FullName")
    private String FullName;
    @Id
    @Column(name="PhoneNumber")
    private String PhoneNumber;
    @Column(name="Email")
    private String Email;
    @Column(name="Password")
    private String Password;
   

    public User() {
        
    }


   public User(String fullName, String email,String phoneNumber,String password) {
       this.FullName = fullName;
       this.Email = email;
       this.PhoneNumber = phoneNumber;
       this.Password = password;
    }
   
   
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
   
    public String getPhoneNumber() {
        return this.PhoneNumber;
    }
    
    public void seTPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    
    public String getPassword() {
        return this.Password;
    }
    
    public void seTPassword(String Password) {
        this.Password = Password;
    }    
}
