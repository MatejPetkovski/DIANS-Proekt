package com.fuelngo.web.controller;

import com.fuelngo.model.Role;
import com.fuelngo.model.User;
import com.fuelngo.service.FuelStationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
@RequestMapping("/admin")
public class FuelStationController {

    private final FuelStationService fuelStationService;

    public FuelStationController(FuelStationService fuelStationService) {
        this.fuelStationService = fuelStationService;
    }

    @GetMapping("/add")
    public String getAddPage(HttpSession session)
    {
        User user=(User)session.getAttribute("user");
        if(user==null || !user.getRole().equals(Role.ADMIN))
            return "redirect:/home";
        return "addFuelStation";
    }

    @PostMapping("/add")
    public String addFuelStation(@RequestParam String name,@RequestParam String street,@RequestParam Double lon,
                                 @RequestParam Double lat,@RequestParam String website,@RequestParam String phone)
    {
        this.fuelStationService.saveFuelStation(name,street,lat,lon,website,phone);
        return "redirect:/home";
    }
}
