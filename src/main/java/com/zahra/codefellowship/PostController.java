package com.zahra.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Date;

@Controller
public class PostController {
    @Autowired
    PostRepository postRepo;

//    //GET request for posts
//    @RequestMapping(value="/posts", method= RequestMethod.GET)
//    public String getPostsPage (Model m) {
//
//        return "posts";
//
//    }

    @RequestMapping(value ="/allposts", method= RequestMethod.GET)
    public String index(Principal p,Model m){

        m.addAttribute("user",((UsernamePasswordAuthenticationToken)p).getPrincipal());
        return "posts";
    }

    @RequestMapping(value="/posts", method=RequestMethod.POST)
    public RedirectView create(@RequestParam String comment,
                               @RequestParam String createdDate){
        Post newPost = new Post(comment,createdDate);
        postRepo.save(newPost);
        return new RedirectView("/posts");

    }

    //GET request for post
    @RequestMapping(value = "/posts", method=RequestMethod.GET)
    public String posts(){
        return "posts";
    }


}
