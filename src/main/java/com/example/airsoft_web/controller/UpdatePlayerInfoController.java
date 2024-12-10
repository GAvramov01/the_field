package com.example.airsoft_web.controller;

import com.example.airsoft_web.models.dto.PlayerAuthorizationDto;
import com.example.airsoft_web.models.entity.PlayerAuthorization;
import com.example.airsoft_web.service.impl.PlayerAuthorizationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UpdatePlayerInfoController {

    private final PlayerAuthorizationServiceImpl playerAuthorizationServiceImpl;

    public UpdatePlayerInfoController(PlayerAuthorizationServiceImpl playerAuthorizationServiceImpl) {
        this.playerAuthorizationServiceImpl = playerAuthorizationServiceImpl;
    }

    @GetMapping("/updatePlayer")
    public ModelAndView updatePlayer(Model model) {

        model.addAttribute("player", new PlayerAuthorizationDto());
        return new ModelAndView("updatePlayer");

    }

    @PostMapping("/updatePlayer")
    public String updatePlayer(PlayerAuthorizationDto playerAuthorizationDto, HttpSession session) {

        PlayerAuthorization updatePlayer = playerAuthorizationServiceImpl.updatePlayerInfo(playerAuthorizationDto);

//        playerAuthorizationServiceImpl.updatePlayerInfo(playerAuthorizationDto);

        session.setAttribute("loggedPlayerAuthorization", updatePlayer);

        return "player_page";
    }
}
