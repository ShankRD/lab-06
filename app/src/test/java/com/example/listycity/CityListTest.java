package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Kupondole", "Kathmandu");
        cityList.add(city);

        assertTrue(cityList.hasCity(city));
        assertFalse(cityList.hasCity(new City("Red Deer", "Alberta"))); //thsi one shoudlnt work
    }

    @Test
    public void testDeleteCity() {
        CityList cityList = mockCityList();
        City city = new City("Kupondole", "Kathmandu");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.hasCity(city));

        cityList.deleteCity(city);

        assertEquals(1, cityList.getCities().size());
        assertFalse(cityList.hasCity(city)); //need to rechck this
    }

    @Test
    public void testDeleteCityException() {
        CityList cityList = mockCityList();
        City city = new City("Kupondole", "Kathmandu");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(city);
        });
    }

    @Test
    public void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.howManyCities()); // mockCityList adds 1 city initially

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.howManyCities());

        cityList.deleteCity(city);
        assertEquals(1, cityList.howManyCities());
    }

}