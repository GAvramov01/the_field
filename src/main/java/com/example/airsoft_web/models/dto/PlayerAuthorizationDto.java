package com.example.airsoft_web.models.dto;

import com.example.airsoft_web.models.entity.City;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerAuthorizationDto {

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private City city = new City();

    private PlayerDto player;
}
