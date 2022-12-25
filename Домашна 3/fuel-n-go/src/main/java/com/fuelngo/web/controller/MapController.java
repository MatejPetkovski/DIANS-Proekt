package com.fuelngo.web.controller;

import com.fuelngo.model.exceptions.FuelStationNotFoundException;
import com.fuelngo.service.FuelStationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/map")
public class MapController {

    private final FuelStationService fuelStationService;

    public MapController(FuelStationService fuelStationService) {
        this.fuelStationService = fuelStationService;
    }

    @GetMapping
    public String showAllFuelStations(Model model)
    {
        model.addAttribute("stations",fuelStationService.getAllFuelStations());
        return "map";
    }


    @GetMapping("/{name}")
    public String showMap(@PathVariable String name, Model model)
    {

        model.addAttribute("stations",fuelStationService.getFuelStationsByNames(name));
        return "map";
    }

    @GetMapping("/route/{id}")
    public String routeToFuelStation(@PathVariable Long id,Model model)
    {
        try {
            model.addAttribute("station", fuelStationService.findById(id));
            return "routing";
        }catch (FuelStationNotFoundException e)
        {
            return "redirect:/map";
        }
    }
}
