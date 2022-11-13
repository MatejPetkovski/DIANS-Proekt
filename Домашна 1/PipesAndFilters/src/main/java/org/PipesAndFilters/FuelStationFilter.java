package org.PipesAndFilters;

import java.util.Map;

//Filtriranje na site benzinski stanici vo Skopje
public class FuelStationFilter implements Filter<String>{

    Map<String,Integer> columnsMap;

    public FuelStationFilter(Map<String, Integer> columnsMap) {
        this.columnsMap = columnsMap;
    }

    @Override
    public String execute(String input) {
        String [] columns=input.split(",",-1);
        String result="";
        if(columns[columnsMap.get("amenity")].equals("fuel"))
        {
            result+=input;
        }
        return result;
    }

}
