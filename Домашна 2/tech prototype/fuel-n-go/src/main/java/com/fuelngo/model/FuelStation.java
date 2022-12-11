package com.fuelngo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "fuelstation")
public class FuelStation {
    @Id
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
