package org.PipesAndFilters;

import java.util.List;
import java.util.Map;


//Filtriranje na nepotrebni atributi vo csv fajlot
public class AttributesFilter implements Filter<String>{
    List<String> attributesToStay;
    Map<String,Integer> attributesMap;

    public AttributesFilter(List<String> attributesToStay, Map<String, Integer> attributesMap) {
        this.attributesToStay = attributesToStay;
        this.attributesMap = attributesMap;
    }

    @Override
    public String execute(String input) {
        String result = "";
        if(!input.isEmpty()) {
            String[] columns = input.split(",", -1);
            for (String attribute : attributesToStay) {
                int columnNumber = attributesMap.get(attribute);
                result += columns[columnNumber] + ",";
            }
            result = result.substring(0, result.length() - 1);
        }
        return result;

    }
}
