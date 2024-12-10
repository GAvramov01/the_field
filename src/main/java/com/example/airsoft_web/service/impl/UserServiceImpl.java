package com.example.airsoft_web.service.impl;

import com.example.airsoft_web.repository.OrganizerRepository;
import com.example.airsoft_web.repository.PlayerAuthorizationRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private final PlayerAuthorizationRepository playerAuthorizationRepository;
    private final OrganizerRepository organizerRepository;

    public UserServiceImpl(PlayerAuthorizationRepository playerAuthorizationRepository, OrganizerRepository organizerRepository) {
        this.playerAuthorizationRepository = playerAuthorizationRepository;
        this.organizerRepository = organizerRepository;
    }

    public boolean emailExists(String email) {
        return playerAuthorizationRepository.existsByEmail(email) || organizerRepository.existsByEmail(email);
    }
}
