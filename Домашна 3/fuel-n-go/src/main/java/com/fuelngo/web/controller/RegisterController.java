package com.fuelngo.web.controller;

import com.fuelngo.model.User;
import com.fuelngo.model.exceptions.InvalidArgumentsException;
import com.fuelngo.model.exceptions.InvalidEmailException;
import com.fuelngo.model.exceptions.PasswordsNotMatchingException;
import com.fuelngo.model.exceptions.UserAlreadyExistsException;
import com.fuelngo.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthenticationService authenticationService;

    public RegisterController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String getPage()
    {
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String email_address, @RequestParam String username,
                           @RequestParam String password, @RequestParam String repeatPassword, Model model)
    {
        User user=null;
        try{
            user=this.authenticationService.register(email_address,username,password,repeatPassword);
            return "redirect:/login";
        }catch (InvalidArgumentsException | UserAlreadyExistsException | PasswordsNotMatchingException |
                InvalidEmailException e )
        {
            model.addAttribute("error",true);
            model.addAttribute("errorMsg",e.getMessage());
            return "register";
        }
    }

}
