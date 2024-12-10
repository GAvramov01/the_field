package com.example.airsoft_web.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("iso")
    private String iso;

    @JsonProperty("region")
    private String region;

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lng")
    private String lng;

    @JsonProperty("country")
    private String country;

    @JsonProperty("capital")
    private String capital;

    @JsonProperty("population")
    private String population;

    @JsonProperty("population_proper")
    private String populationProper;

}
