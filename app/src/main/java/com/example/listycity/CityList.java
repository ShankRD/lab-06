package com.example.listycity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This is the constructor for CityList
     */
    public CityList() {
        // causes warning in javadoc without this
    }

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This checks if the city belongs in the list
     * @param city
     * The city to check for
     * @return
     * Returns true if the city is in the list, otherwise returns false
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This deletes a city from the list if it exists
     * @param city
     * The city to delete
     * @throws IllegalArgumentException
     * Throws exception if the city is not found in the list
     */
    public void deleteCity(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        } else cities.remove(city);
    }

    /**
     * This returns the total number of cities in the list
     * @return
     * Returns the integer size of cities
     */
    public int howManyCities() {
        return cities.size();
    }
}