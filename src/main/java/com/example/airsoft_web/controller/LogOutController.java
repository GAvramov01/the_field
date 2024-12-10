package com.example.airsoft_web.controller;

import com.example.airsoft_web.models.entity.Tournament;
import com.example.airsoft_web.service.PlayerAuthorizationService;
import com.example.airsoft_web.service.impl.TournamentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LogOutController {

    private final PlayerAuthorizationService playerAuthorizationService;
    private final TournamentServiceImpl tournamentServiceImpl;

    public LogOutController(PlayerAuthorizationService playerAuthorizationService, TournamentServiceImpl tournamentServiceImpl) {
        this.playerAuthorizationService = playerAuthorizationService;
        this.tournamentServiceImpl = tournamentServiceImpl;
    }

    @GetMapping("/player_page")
    public String playerPage(){
        return "player_page";
    }

    @PostMapping("/logout")
    public ModelAndView logout() {

        playerAuthorizationService.logout();

        return new ModelAndView("index");
    }

    // Get request for loading tournament page
    @GetMapping("/tournament_page")
    public String tournamentPage(Model model) {

        List<Tournament> tournaments = tournamentServiceImpl.getAllTournaments();

        model.addAttribute("tournaments", tournaments);

        return "tournament_page";
    }
}
