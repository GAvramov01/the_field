package com.example.airsoft_web.service;

import com.example.airsoft_web.models.entity.City;

import java.io.IOException;
import java.util.List;

public interface CityService {

//    public String readCitiesFromFile() throws IOException;

//    public City findCityById(long id);

    public City findCityByName(String name);

    public List<City> findAllCities();

}
