package com.example.airsoft_web.controller;

import com.example.airsoft_web.models.dto.OrganizerDto;
import com.example.airsoft_web.models.dto.PlayerAuthorizationDto;
import com.example.airsoft_web.models.entity.City;
import com.example.airsoft_web.repository.CityRepository;
import com.example.airsoft_web.repository.OrganizerRepository;
import com.example.airsoft_web.service.impl.PlayerAuthorizationServiceImpl;
import com.example.airsoft_web.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RegisterPlayerController {

    private final PlayerAuthorizationServiceImpl playerAuthorizationServiceImpl;
    private final CityRepository cityRepository;
    private final UserServiceImpl userServiceImpl;

    public RegisterPlayerController(PlayerAuthorizationServiceImpl playerAuthorizationServiceImpl, CityRepository cityRepository, UserServiceImpl userServiceImpl) {
        this.playerAuthorizationServiceImpl = playerAuthorizationServiceImpl;
        this.cityRepository = cityRepository;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/register_player")
    public ModelAndView register(Model model) {
        List<City> cities = cityRepository.findAllByOrderByNameAsc();
        model.addAttribute("cities", cities);

        PlayerAuthorizationDto playerAuthorizationDto = new PlayerAuthorizationDto();
        playerAuthorizationDto.setCity(new City());
        model.addAttribute("playerAuthorizationDTO", new PlayerAuthorizationDto());
        return new ModelAndView("register_player");
    }

    @PostMapping("/register_player")
    public ModelAndView register(@ModelAttribute("playerAuthorizationDTO") PlayerAuthorizationDto playerAuthorizationDTO, Model model) {

        if (userServiceImpl.emailExists(playerAuthorizationDTO.getEmail())) {
            model.addAttribute("error", "This email already exist!");
            return new ModelAndView("register_player");
        }
        this.playerAuthorizationServiceImpl.playerRegistration(playerAuthorizationDTO);

        return new ModelAndView("player_page");
    }
}
