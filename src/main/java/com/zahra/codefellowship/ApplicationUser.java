package com.zahra.codefellowship;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity

public class ApplicationUser implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long id;
    @Column(unique = true) //doing?
    public String username;
    public String password;
    public String firstName;
    public String lastName;
    public String dateofBirth;
    public String bio;

    @OneToMany(mappedBy="applicationUser")
    public List<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "user_followers",
            joinColumns = { @JoinColumn(name = "follower_id") },
            inverseJoinColumns = { @JoinColumn(name = "followed_id") }
    )
    Set<ApplicationUser> usersThatIFollow;

    @ManyToMany(mappedBy = "usersThatIFollow")
    public Set<ApplicationUser> usersThatFollowMe;


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


public String toString (){
        return firstName+"\n"+lastName+"\n"+dateofBirth+"\n"+bio+"\n"+username+ "Users that follow me are "+usersThatFollowMe + "Users that I follow are "+ usersThatIFollow;
}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true ;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<Post>getPosts(){
        return posts;
    }
}
