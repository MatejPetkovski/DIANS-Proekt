package com.fuelngo.web.controller;

import com.fuelngo.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("/logout")
public class LogOutController {


    @GetMapping
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/home";
    }
}
