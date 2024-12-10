package com.example.airsoft_web.controller;

import com.example.airsoft_web.models.dto.OrganizerDto;
import com.example.airsoft_web.models.dto.PlayerAuthorizationDto;
import com.example.airsoft_web.models.entity.Organizer;
import com.example.airsoft_web.repository.OrganizerRepository;
import com.example.airsoft_web.service.impl.OrganizerServiceImpl;
import com.example.airsoft_web.service.impl.PlayerAuthorizationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final PlayerAuthorizationServiceImpl playerAuthorizationServiceImpl;
    private final OrganizerServiceImpl organizerServiceImpl;

    public LoginController(PlayerAuthorizationServiceImpl playerAuthorizationServiceImpl, OrganizerServiceImpl organizerServiceImpl) {
        this.playerAuthorizationServiceImpl = playerAuthorizationServiceImpl;
        this.organizerServiceImpl = organizerServiceImpl;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

//    @PostMapping("/login")
//    public ModelAndView login(PlayerAuthorizationDto playerAuthorizationDTO, HttpSession session) {
//
//        boolean isLoggedIn = playerAuthorizationServiceImpl.login(playerAuthorizationDTO, session);
//
//        if (isLoggedIn) {
//            return new ModelAndView("player_page");
//        }
//        return new ModelAndView("redirect:/index");
//    }

    @PostMapping("/login")
    public ModelAndView login(PlayerAuthorizationDto playerAuthorizationDto, OrganizerDto organizerDto, HttpSession session) {

        boolean playerLogin = playerAuthorizationServiceImpl.loginPlayer(playerAuthorizationDto, session);

        if (playerLogin) {
            return new ModelAndView("player_page");
        }

        boolean organizerLogin = organizerServiceImpl.loginOrganizer(organizerDto, session);

        if (organizerLogin) {

            return new ModelAndView("organizer_page");
        }
        return new ModelAndView("index");
    }
}
