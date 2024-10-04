package com.example.airsoft_web.service.impl;

import com.example.airsoft_web.models.dto.PlayerAuthorizationDto;
import com.example.airsoft_web.models.entity.City;
import com.example.airsoft_web.models.entity.Player;
import com.example.airsoft_web.models.entity.PlayerAuthorization;
import com.example.airsoft_web.repository.CityRepository;
import com.example.airsoft_web.repository.PlayerAuthorizationRepository;
import com.example.airsoft_web.service.PlayerAuthorizationService;
import com.example.airsoft_web.service.session.LoggedPlayerAuthorization;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class PlayerAuthorizationServiceImpl implements PlayerAuthorizationService {

    private final PlayerAuthorizationRepository playerAuthorisationRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final LoggedPlayerAuthorization loggedPlayer;
    private final CityRepository cityRepository;

    public PlayerAuthorizationServiceImpl(PlayerAuthorizationRepository playerAuthorisationRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, LoggedPlayerAuthorization loggedPlayer, CityRepository cityRepository) {
        this.playerAuthorisationRepository = playerAuthorisationRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.loggedPlayer = loggedPlayer;
        this.cityRepository = cityRepository;
    }

    @Override
    public PlayerAuthorization playerRegistration(PlayerAuthorizationDto playerAuthorizationDTO) {

        PlayerAuthorization pa = new PlayerAuthorization();

        pa.setFirstName(playerAuthorizationDTO.getFirstName());
        pa.setLastName(playerAuthorizationDTO.getLastName());
        pa.setEmail(playerAuthorizationDTO.getEmail());
        pa.setPassword(passwordEncoder.encode(playerAuthorizationDTO.getPassword()));

        City city = cityRepository.findById(playerAuthorizationDTO.getCity().getId());
        pa.setCity(city);

        Player player = new Player();
        player.setPlayedGames(0);
        player.setKills(0);
        player.setDeaths(0);
        player.setStatisticGames(0.0);
        pa.setPlayer(player);

        modelMapper.map(player, Player.class);
        modelMapper.map(pa, PlayerAuthorization.class);

        printLoggedPlayer(pa);

        return playerAuthorisationRepository.save(pa);
    }

    @Override
    public boolean login(PlayerAuthorizationDto playerAuthorizationDTO, HttpSession session) {

        String lastName = playerAuthorizationDTO.getLastName();
        String password = playerAuthorizationDTO.getPassword();

        PlayerAuthorization pa = this.playerAuthorisationRepository.findByLastName(lastName);

        if (pa == null) {
            throw new IllegalArgumentException("User with that last name -> " + lastName + " <- does not exist");
        }

        boolean matchPasswords = passwordEncoder.matches(password, pa.getPassword());

        if (!matchPasswords) {
            throw new IllegalArgumentException("Wrong password");
        }

        session.setAttribute("loggedPlayer", pa);

        printLoggedPlayer(pa);

        return matchPasswords;
    }

    @Override
    public void logout() {
        loggedPlayer.defaultReset();
    }

    private LoggedPlayerAuthorization printLoggedPlayer(PlayerAuthorization pa) {

        loggedPlayer.setFirstName(pa.getFirstName());
        loggedPlayer.setLastName(pa.getLastName());
        loggedPlayer.setEmail(pa.getEmail());
        loggedPlayer.setCity(pa.getCity().getName());

        return loggedPlayer;
    }
}
