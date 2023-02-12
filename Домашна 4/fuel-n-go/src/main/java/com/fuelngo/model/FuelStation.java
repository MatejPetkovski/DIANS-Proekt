package com.fuelngo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fuelstation")
public class FuelStation {
    @Id
    @GeneratedValue()
    private Long id;
    private double lat;
    private double lon;
    private String amenity;
    private String int_name;
    private String name;
    private String name_en;
    private String addr_city;
    private String addr_street;
    private String addr_postcode;
    private String phone;
    private String website;

    public FuelStation() {
    }

    public FuelStation(double lat, double lon, String name, String addr_street, String phone, String website) {
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.addr_street = addr_street;
        this.phone = phone;
        this.website = website;
    }

    public String getDescription()
    {
       StringBuilder sb=new StringBuilder();
       sb.append(String.format("%s",name));
       if(addr_street!=null) {
           sb.append("\n");
           sb.append(String.format(" Улица: %s", addr_street));
       }
       if(phone!=null) {
           sb.append("\n");
           sb.append(String.format(" Телефон: %s", phone));
       }
       if(website!=null) {
           sb.append("\n");
           sb.append(String.format(" Веб страница: %s", website));
       }

       return sb.toString();
    }
}
