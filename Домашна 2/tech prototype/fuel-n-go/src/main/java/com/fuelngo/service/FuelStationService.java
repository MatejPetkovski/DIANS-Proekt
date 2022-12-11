package com.fuelngo.service;

import com.fuelngo.model.FuelStation;

import java.util.List;

public interface FuelStationService {


    List<String> getAllDistinctFuelStationsNames();

    List<FuelStation> getFuelStationsByNames(String name);

    List<FuelStation> getAllFuelStations();
}
