package com.zahra.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ApplicationUserController {
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private ApplicationUserRepository userRepo;
    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index (Model m) {

        return "codeFellowHome";

    }

    //GET request for signup
    @RequestMapping(value="/signup", method= RequestMethod.GET)
    public String index2 (Model m) {

        return "signup";

        //want to provide information and also button to sign up
        //button can have an action and a method that takes you to /applicationUsers
    }
    //GET request for displaying bio/people
    @RequestMapping(value="/users/{id}", method=RequestMethod.GET)
    public String index3 (Model m){
        //grab all the information from the database

        //display them on a page

        m.addAttribute("users", userRepo.findAll());
        return "people";
    }


    @RequestMapping(value="/signup",method=RequestMethod.POST)
    public RedirectView create (@RequestParam String username,
                                    @RequestParam String password,
                                    @RequestParam String firstName,
                                    @RequestParam String lastName,
                                    @RequestParam String dateofBirth,
                                    @RequestParam String bio){

            //salt
            //see if it requires a variable that need to be passed in as password or if pw is already incpripted
           password = bCryptPasswordEncoder.encode(password);
            ApplicationUser newUser = new ApplicationUser(username,password,firstName,lastName,dateofBirth,bio);
            userRepo.save(newUser);
            return new  RedirectView("/");

            //link that takes them to the form --> signup
            //the form redirects them back to home --->sub ---/
        }


}
