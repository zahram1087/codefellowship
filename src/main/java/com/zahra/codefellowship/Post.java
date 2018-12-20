package com.zahra.codefellowship;

import javax.persistence.*;
import java.security.Principal;
import java.security.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import static java.text.DateFormat.getDateTimeInstance;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;
    public String comment;
    public Date createdDate;




    @ManyToOne
    public ApplicationUser applicationUser;

    public  Post(){}

    public Post (String comment, Date createdDate  ){
        this.comment=comment;
        this.createdDate=createdDate;

    }

    public String toString(){
        return "Comment: "+ comment+"\n"+"By: "+ this.applicationUser;
    }

    public void addPost(Post post) {

    }

    public  Date getCreatedDate (){
        DateFormat.getDateTimeInstance().format(createdDate);
        return createdDate;
    }



    //user =albuums;
    //post-songs;
    //create temple for post
}
