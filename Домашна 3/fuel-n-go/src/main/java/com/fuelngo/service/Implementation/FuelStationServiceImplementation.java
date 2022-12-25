package com.fuelngo.service.Implementation;

import com.fuelngo.model.FuelStation;
import com.fuelngo.model.exceptions.FuelStationNotFoundException;
import com.fuelngo.repository.FuelStationRepository;
import com.fuelngo.service.FuelStationService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
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

    @Override
    public FuelStation findById(Long id) {
       return this.fuelStationRepository.findById(id).orElseThrow(() -> new FuelStationNotFoundException(id));
    }

    @Override
    public List<String> getFuelPrices() throws IOException {
        Document document= Jsoup.connect("https://mk.fuelo.net/?lang=en").get();
        String gas=document.select("body > div.page-wrapper > div.container > div > div.content.col-sm-8.col-md-8 > div:nth-child(2) > div:nth-child(2) > h3 > span").text();
        String diesel=document.select("body > div.page-wrapper > div.container > div > div.content.col-sm-8.col-md-8 > div:nth-child(2) > div:nth-child(3) > h3 > span").text();
        String lpg=document.select("body > div.page-wrapper > div.container > div > div.content.col-sm-8.col-md-8 > div:nth-child(2) > div:nth-child(4) > h3 > span").text();
        List<String> fuelPrices=new ArrayList<>();
        fuelPrices.add(gas);
        fuelPrices.add(diesel);
        fuelPrices.add(lpg);
        return fuelPrices;
    }
}
