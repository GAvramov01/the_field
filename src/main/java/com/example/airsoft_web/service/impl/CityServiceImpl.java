package com.example.airsoft_web.service.impl;

import com.example.airsoft_web.models.dto.CityDto;
import com.example.airsoft_web.models.entity.City;
import com.example.airsoft_web.repository.CityRepository;
import com.example.airsoft_web.service.CityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CityServiceImpl(CityRepository cityRepository, ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public City findCityByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public List<City> findAllCities() {
        return cityRepository.findAllByOrderByNameAsc();
    }

    /*
        Comment: Read all cities from Json file
    */
//    @PostConstruct
//    public void loadCitiesFromFile() {
//        try (InputStream inputStream = getClass().getResourceAsStream("/files/json/cities.json")) {
//            List<CityDto> cites = objectMapper.readValue(inputStream, new TypeReference<List<CityDto>>() {
//            });
//            List<City> cityList = cites
//                    .stream()
//                    .map(dto -> modelMapper.map(dto, City.class))
//                    .toList();
//
//            cityRepository.saveAll(cityList);
//            System.out.println("Cities loaded successfully");
//        } catch (Exception e) {
//            System.err.println("Error loading cities from files " + e.getMessage());
//            e.printStackTrace();
//        }
//    }

//    @Override
//    public List<City> findAllCities() {
//        return cityRepository.findAllByOrderByNameAsc();
//    }

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
