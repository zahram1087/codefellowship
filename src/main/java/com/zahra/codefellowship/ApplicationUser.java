package com.zahra.codefellowship;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class ApplicationUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;
    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public String dateofBirth;
    public String bio;


    public ApplicationUser(){}

    //constructor
    public ApplicationUser (String username, String password,String firstName, String lastName, String dateofBirth ,String bio){
        this.username = username;
        this.password= password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateofBirth = dateofBirth;
        this.bio = bio;

    }

    //username, password (hashed using BCrypt), firstName, lastName, dateOfBirth,

public String toString (){
        return firstName+"\n"+lastName+"\n"+dateofBirth+"\n"+bio+"\n"+username;
}

}
