package com.fuelngo.web.controller;

import com.fuelngo.model.FuelStation;
import com.fuelngo.service.FuelStationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/liststations")
public class ListFuelStationsController {

    private final FuelStationService fuelStationService;

    public ListFuelStationsController(FuelStationService fuelStationService) {
        this.fuelStationService = fuelStationService;
    }

    @GetMapping
    public String getPage(Model model, @RequestParam(required = false) String name)
    {
        List<String> stations=null;
        if(name!=null)
            stations=this.fuelStationService.getFuelStationNamesByName(name);
        else
            stations=this.fuelStationService.getAllDistinctFuelStationsNames();

        model.addAttribute("stations",stations);
        return "search";
    }




}
