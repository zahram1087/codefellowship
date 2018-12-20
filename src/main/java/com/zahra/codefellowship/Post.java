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
    public String createdDate;




    @ManyToOne
    public ApplicationUser applicationUser;

    public  Post(){}

    public Post (String comment, String createdDate  ){
        this.comment=comment;
        this.createdDate=createdDate;

    }

    public String toString(){
        return "Comment: "+ comment+"\n"+"By: "+ this.applicationUser;
    }

    //user =albums;
    //post-songs;
    //create temple for post
}
