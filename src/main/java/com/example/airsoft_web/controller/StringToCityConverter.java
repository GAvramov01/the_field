package com.example.airsoft_web.controller;

import com.example.airsoft_web.models.entity.City;
import com.example.airsoft_web.repository.CityRepository;
import org.modelmapper.Converters;
import org.springframework.stereotype.Component;

@Component
public class StringToCityConverter implements Converters.Converter<String, City> {

    private CityRepository cityRepository;

    public City convert(String source) {
        return cityRepository.findByName(source.trim());
    }
}
