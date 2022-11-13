package org.PipesAndFilters;

import java.io.*;
import java.util.*;

public class PipesAndFiltersMain {
    public static void main(String[] args) throws IOException {
        Pipe<String> pipe=new Pipe<>();

        Scanner scanner=new Scanner(new File("C:\\Users\\teope\\OneDrive\\Desktop\\FINKI\\V semestar\\Dizajn i Arhitektura na softver\\Proekt\\Domasna 1\\Data\\Skopje.csv"));
        scanner.useDelimiter(",");
        FileWriter writer=new FileWriter("C:\\Users\\teope\\OneDrive\\Desktop\\FINKI\\V semestar\\Dizajn i Arhitektura na softver\\Proekt\\Domasna 1\\Data\\FilteredSkopjeFuelStations.csv");

        //Sobiranje na site iminja na koloni vo mapa
        String attributeLine=scanner.nextLine();
        String [] attributesArray=attributeLine.split(",");
        Map<String,Integer> attributes=new HashMap<>();
        for(int i=0;i<attributesArray.length;i++)
            attributes.put(attributesArray[i],i);

        //Lista od koloni koi sakame da gi zacuvame vo csv fajlot
        List<String> attributesToStay=new ArrayList<>(Arrays.asList("@id","@lat","@lon" ,"amenity", "int_name" ,"name", "name:en" ,"addr:city", "addr:street", "addr:postcode" ,"phone","website"));

        //Pisuvanje na iminjata na kolonite koi ke ostanat po filtracija vo csv fajlot
        writer.write(String.join(",",attributesToStay)+"\n");
        writer.flush();

        FuelStationFilter fuelStationFilter=new FuelStationFilter(attributes);
        DeleteNullNamesFilter deleteNullNamesFilter=new DeleteNullNamesFilter(attributes);
        AttributesFilter attributesFilter=new AttributesFilter(attributesToStay,attributes);

        pipe.addFilter(fuelStationFilter);
        pipe.addFilter(deleteNullNamesFilter);
        pipe.addFilter(attributesFilter);




        while(scanner.hasNext())
        {
            String line= pipe.runFilter(scanner.nextLine());
            if(!line.isEmpty()) {
                writer.write(line + '\n');
                writer.flush();
            }

        }
        writer.close();


    }
}
