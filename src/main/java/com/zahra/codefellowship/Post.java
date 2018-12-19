package com.zahra.codefellowship;

import javax.persistence.*;
import java.security.Principal;
import java.security.Timestamp;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;
    public String comment;
    public Timestamp ts;



    @ManyToOne
    public ApplicationUser applicationUser;

    public  Post(){}

    public Post (String comment,Timestamp ts ){
        this.comment=comment;
        this.ts = 

    }

    public String toString(){
        return "Comment: "+ comment+"\n"+"Time: "+ date+"\n"+"By: "+ this.applicationUser;
    }

    //user =albums;
    //post-songs;
    //create temple for post
}
