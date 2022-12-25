package com.fuelngo.web.controller;

import com.fuelngo.service.FuelStationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping({"/home","/"})
public class HomeController {

    private final FuelStationService fuelStationService;

    public HomeController(FuelStationService fuelStationService) {
        this.fuelStationService = fuelStationService;
    }

    @GetMapping
    public String getPage(Model model) throws IOException {
        model.addAttribute("fuelPrices",this.fuelStationService.getFuelPrices());
        return "home";
    }

}
