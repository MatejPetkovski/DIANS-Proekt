package com.fuelngo.web.controller;

import com.fuelngo.service.FuelStationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/liststations")
public class ListFuelStationsController {

    private final FuelStationService fuelStationService;

    public ListFuelStationsController(FuelStationService fuelStationService) {
        this.fuelStationService = fuelStationService;
    }

    @GetMapping
    public String getPage(Model model)
    {
        model.addAttribute("stations",fuelStationService.getAllDistinctFuelStationsNames());
        return "search";
    }




}
