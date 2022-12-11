package com.fuelngo.web.controller;

import com.fuelngo.model.User;
import com.fuelngo.model.exceptions.InvalidArgumentsException;
import com.fuelngo.model.exceptions.InvalidCredentialsException;
import com.fuelngo.service.AuthenticationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LogInController {


    private final AuthenticationService authenticationService;

    public LogInController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String getPage()
    {

        return "login";
    }

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model)
    {
        User user=null;
        try {
            user=authenticationService.login(username,password);
            session.setAttribute("user",user);
            return "redirect:/home";
        }catch (InvalidArgumentsException | InvalidCredentialsException e)
        {
            model.addAttribute("error",true);
            model.addAttribute("errorMsg",e.getMessage());
            return "login";
        }
    }
}
