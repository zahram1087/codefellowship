package com.zahra.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Date;

@Controller
public class PostController {
    @Autowired
    PostRepository postRepo;

    @Autowired
    private ApplicationUserRepository userRepo;


    @RequestMapping(value ="/allposts", method= RequestMethod.GET)
    public String index(Principal p,Model m){

        m.addAttribute("user",((UsernamePasswordAuthenticationToken)p).getPrincipal());
        return "posts";
    }

    @PostMapping(value="/users/{userId}/post")
    public RedirectView addPost(@PathVariable long userId,
                               @RequestParam String comment){
        ApplicationUser user = userRepo.findById(userId).get();

        Post post = new Post(comment, new Date());
        post.applicationUser = user;

        postRepo.save(post);
        return new RedirectView("/users/{userId}");

    }
    @GetMapping("/users/{userId}")
    public String getPosts(@PathVariable long userId, Model model) {

        model.addAttribute("user", userRepo.findById(userId).get());
        return "posts";
    }

    @RequestMapping(value="/myPosts", method=RequestMethod.GET)
    public String myPosts(Principal p,
                            Model m){
        //grab all the information from the database
        System.out.println(p);

        m.addAttribute("user",((UsernamePasswordAuthenticationToken)p).getPrincipal());

        return "posts";
    }


}
