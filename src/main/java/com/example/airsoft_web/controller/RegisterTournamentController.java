package com.example.airsoft_web.controller;

import com.example.airsoft_web.models.dto.OrganizerDto;
import com.example.airsoft_web.models.dto.TournamentDto;
import com.example.airsoft_web.models.entity.City;
import com.example.airsoft_web.models.entity.Organizer;
import com.example.airsoft_web.repository.CityRepository;
import com.example.airsoft_web.repository.OrganizerRepository;
import com.example.airsoft_web.service.impl.TournamentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RegisterTournamentController {

    private final CityRepository cityRepository;
    private final TournamentServiceImpl tournamentServiceImpl;
    private final OrganizerRepository organizerRepository;
    private final OrganizerDto organizerDto;

    public RegisterTournamentController(CityRepository cityRepository, TournamentServiceImpl tournamentServiceImpl, OrganizerRepository organizerRepository, OrganizerDto organizerDto) {
        this.cityRepository = cityRepository;
        this.tournamentServiceImpl = tournamentServiceImpl;
        this.organizerRepository = organizerRepository;
        this.organizerDto = organizerDto;
    }

    @GetMapping("/register_tournament")
    public ModelAndView registerTournament(Model model) {

        List<City> cities = cityRepository.findAllByOrderByNameAsc();
        model.addAttribute("cities", cities);

        TournamentDto tournamentDto = new TournamentDto();
        model.addAttribute("tournamentDto", tournamentDto);

        return new ModelAndView("register_tournament");
    }

    @PostMapping("/register_tournament")
    public ModelAndView registerTournament(@ModelAttribute TournamentDto tournamentDto, HttpSession httpSession) {

//        if (bindingResult.hasErrors()) {
//            return new ModelAndView("index").addObject("org.springframework.validation.BindingResult.tournamentDto", bindingResult);
//        }

        Organizer organizer = (Organizer) httpSession.getAttribute("loggedOrganizer");
        this.tournamentServiceImpl.registerTournament(tournamentDto, organizer);

        return new ModelAndView("index");
    }
}
