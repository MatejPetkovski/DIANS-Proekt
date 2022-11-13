package org.PipesAndFilters;

import java.util.Map;

//Brisenje na site redovi koi nemaat ime
public class DeleteNullNamesFilter implements Filter<String>{
    Map<String,Integer> columnsMap;

    public DeleteNullNamesFilter(Map<String, Integer> columnsMap) {
        this.columnsMap = columnsMap;
    }

    @Override
    public String execute(String input) {
        String result = "";
        if(!input.isEmpty()) {
            String[] columns = input.split(",", -1);
            if (!columns[columnsMap.get("name")].isEmpty() || !columns[columnsMap.get("name:en")].isEmpty() || !columns[columnsMap.get("int_name")].isEmpty()) {
                result += input;
            }
        }
        return result;
    }
}
