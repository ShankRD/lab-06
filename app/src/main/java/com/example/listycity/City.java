package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * This makes the city and province
     * @param city
     * The name of the city
     * @param province
     * The name of the province
     */
    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }


    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }

}

