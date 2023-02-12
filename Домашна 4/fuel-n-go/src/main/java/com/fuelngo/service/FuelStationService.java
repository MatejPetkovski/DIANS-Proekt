package com.fuelngo.service;

import com.fuelngo.model.FuelStation;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface FuelStationService {


    List<String> getAllDistinctFuelStationsNames();
    List<String> getFuelStationNamesByName(String name);

    List<FuelStation> getFuelStationsByNames(String name);

    List<FuelStation> getAllFuelStations();

    FuelStation findById(Long id);

    List<String> getFuelPrices() throws IOException;

    Optional<FuelStation> saveFuelStation(String name, String street, Double lat, Double lon, String website, String phone);

}
