package com.example.airsoft_web.service;

import com.example.airsoft_web.models.dto.PlayerAuthorizationDto;
import com.example.airsoft_web.models.entity.PlayerAuthorization;

import javax.servlet.http.HttpSession;

public interface PlayerAuthorizationService {

    public PlayerAuthorization playerRegistration(PlayerAuthorizationDto playerAuthorizationDTO);

    boolean login(PlayerAuthorizationDto playerAuthorizationDTO, HttpSession session);

    void logout();
}
