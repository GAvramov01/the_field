package com.example.airsoft_web.controller;

import com.example.airsoft_web.models.dto.PlayerAuthorizationDto;
import com.example.airsoft_web.service.PlayerAuthorizationService;
import com.example.airsoft_web.service.impl.PlayerAuthorizationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginPlayerController {

    private final PlayerAuthorizationService playerAuthorizationService;
    private final PlayerAuthorizationServiceImpl playerAuthorizationServiceImpl;

    public LoginPlayerController(PlayerAuthorizationService playerAuthorizationService, PlayerAuthorizationServiceImpl playerAuthorizationServiceImpl) {
        this.playerAuthorizationService = playerAuthorizationService;
        this.playerAuthorizationServiceImpl = playerAuthorizationServiceImpl;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(PlayerAuthorizationDto playerAuthorizationDTO, HttpSession session) {

        boolean isLoggedIn = playerAuthorizationServiceImpl.login(playerAuthorizationDTO, session);

        if (isLoggedIn) {
            return new ModelAndView("player_page");
        }
        return new ModelAndView("redirect:/");
    }

    @PostMapping("/logout")
    public ModelAndView logout() {

        playerAuthorizationService.logout();

        return new ModelAndView("redirect:/index");
    }
}
