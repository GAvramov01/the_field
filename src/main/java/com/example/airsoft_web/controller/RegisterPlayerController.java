package com.example.airsoft_web.controller;

import com.example.airsoft_web.models.dto.PlayerAuthorizationDto;
import com.example.airsoft_web.models.entity.City;
import com.example.airsoft_web.repository.CityRepository;
import com.example.airsoft_web.repository.PlayerRepository;
import com.example.airsoft_web.service.PlayerAuthorizationService;
import com.example.airsoft_web.service.impl.PlayerAuthorizationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RegisterPlayerController {

    private final PlayerAuthorizationServiceImpl playerAuthorizationServiceImpl;
    private final CityRepository cityRepository;

    public RegisterPlayerController(PlayerAuthorizationServiceImpl playerAuthorizationServiceImpl, CityRepository cityRepository) {
        this.playerAuthorizationServiceImpl = playerAuthorizationServiceImpl;
        this.cityRepository = cityRepository;
    }

    @GetMapping("/register")
    public ModelAndView register(Model model) {
        List<City> cities = cityRepository.findAllByOrderByNameAsc();
        model.addAttribute("cities", cities);
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(PlayerAuthorizationDto playerAuthorizationDTO) {

        this.playerAuthorizationServiceImpl.playerRegistration(playerAuthorizationDTO);

        return new ModelAndView("player_page");
    }
}
