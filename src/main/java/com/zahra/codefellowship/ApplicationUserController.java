package com.zahra.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ApplicationUserController {
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ApplicationUserRepository userRepo;

    @Autowired
    private PostRepository postRepo;
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index (Model m) {

        return "codeFellowHome";
    }

    //GET request for signup
    @RequestMapping(value="/signup", method= RequestMethod.GET)
    public String getSignUpPage (Model m) {

        return "signup";

    }


//    GET request for displaying login user profile
    @RequestMapping(value="/myprofile", method=RequestMethod.GET)
    public String myProfile(Principal p,
                            Model m){
        //grab all the information from the database
        System.out.println(p);

        m.addAttribute("user",((UsernamePasswordAuthenticationToken)p).getPrincipal());

        return "individualUserProfile";
    }

    @RequestMapping(value="/signup",method=RequestMethod.POST)
    public RedirectView create (@RequestParam String username,
                                    @RequestParam String password,
                                    @RequestParam String firstName,
                                    @RequestParam String lastName,
                                    @RequestParam String dateofBirth,
                                    @RequestParam String bio){

            //salt
           password = bCryptPasswordEncoder.encode(password);
            ApplicationUser newUser = new ApplicationUser(username,password,firstName,lastName,dateofBirth,bio);
            userRepo.save(newUser);
            //autologin
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
            return new  RedirectView("/");
        }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/users{id}")
    public String userShow(@PathVariable long id,  Model m){
       Optional <ApplicationUser> u= userRepo.findById(id);
       if(u.isPresent()){
           m.addAttribute("user",u.get());
           return "individualUserProfile";
       }else{
           throw new ResourceNotFoundException();
       }
    }

    //adding posts here



}
// cam from: https://stackoverflow.com/questions/2066946/trigger-404-in-spring-mvc-controller
@ResponseStatus(value = HttpStatus.NOT_FOUND)
class ResourceNotFoundException extends RuntimeException {

}
