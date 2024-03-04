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
@Table (name="student")
public class student implements java.io.Serializable {

    @Id
    @Column(name = "S_id")
    private int id;
    @Column(name = "F_Name")
    private String firstName;
    @Column(name = "L_Name")
    private String lastName;
    
    private static int lastID=0;

    public student() {
        lastID++;
        id=lastID;
    }

    public student(String fname, String lname) {
        lastID++;
        id=lastID;
        this.firstName = fname;
        this.lastName = lname;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
        lastID++;
        id=lastID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}






//    @Id
//    @Column(name = "personID")
//    private int id=0;
//    public Person() {
//        id++;
//    }
//
//    public Person(String name, int age) {
//        id++;
//        this.name = name;
//        this.age = age;
//    }
//
//    public Person(int id, String name, int age) {
//        id++;
//        this.id = id;
//        this.name = name;
//        this.age = age;
//    }


