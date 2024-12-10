package com.example.airsoft_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlayerOrganizerController {

    @GetMapping("/player_organizator")
    public String playerOrganizator() {
        return "player_organizer";
    }
}
