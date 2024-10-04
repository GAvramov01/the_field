package com.example.airsoft_web.service.impl;

import com.example.airsoft_web.models.entity.City;
import com.example.airsoft_web.repository.CityRepository;
import com.example.airsoft_web.service.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

//    private final static String CITY_PATH = "src/main/resources/files/json/cities.json";
//    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;
    private final CityRepository cityRepository;

    public CityServiceImpl(ModelMapper modelMapper, CityRepository cityRepository) {
        this.modelMapper = modelMapper;
        this.cityRepository = cityRepository;
    }

    @Override
    public City findCityByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public List<City> findAllCities() {
        return cityRepository.findAllByOrderByNameAsc();
    }

    // TODO
//    CityDto gives trouble, cannot find bean
//    private final CityDto cityDto;
//    private final Gson gson;

//    public CityServiceImpl(CityRepository cityRepository, ModelMapper modelMapper, Gson gson) {
//        this.cityRepository = cityRepository;
//        this.modelMapper = modelMapper;
//        this.gson = gson;
//    }

//    @Override
//    public String readCitiesFromFile() throws IOException {
//        return new String(Files.readAllBytes(Path.of(CITY_PATH)));
//    }
//
//    public City findCityById(long id) {
//        Optional<City> byId = cityRepository.findById(id);
//        return byId.get();
//    }

}
