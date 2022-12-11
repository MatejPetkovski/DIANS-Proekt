package com.fuelngo.service.Implementation;

import com.fuelngo.model.FuelStation;
import com.fuelngo.repository.FuelStationRepository;
import com.fuelngo.service.FuelStationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelStationServiceImplementation implements FuelStationService {

    private final FuelStationRepository fuelStationRepository;

    public FuelStationServiceImplementation(FuelStationRepository fuelStationRepository) {
        this.fuelStationRepository = fuelStationRepository;
    }

    @Override
    public List<String> getAllDistinctFuelStationsNames() {
        return fuelStationRepository.findNameDistinct();
    }

    @Override
    public List<FuelStation> getFuelStationsByNames(String name) {
        return fuelStationRepository.findByNameLike(name);
    }

    @Override
    public List<FuelStation> getAllFuelStations() {
        return this.fuelStationRepository.findAll();
    }
}
