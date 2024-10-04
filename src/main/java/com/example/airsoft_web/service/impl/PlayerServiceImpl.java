package com.example.airsoft_web.service.impl;

import com.example.airsoft_web.models.entity.Player;
import com.example.airsoft_web.repository.PlayerRepository;
import com.example.airsoft_web.service.PlayerService;
import com.example.airsoft_web.service.session.LoggedPlayer;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final LoggedPlayer loggedPlayer;

    public PlayerServiceImpl(PlayerRepository playerRepository, LoggedPlayer loggedPlayer) {
        this.playerRepository = playerRepository;
        this.loggedPlayer = loggedPlayer;
    }

    @Override
    public Player getPlayerById(int id) {
        return playerRepository.findById(id);
    }

    private LoggedPlayer printDefaultPlayerInfo(Player player) {

        loggedPlayer.setPlayedGames(player.getPlayedGames());
        loggedPlayer.setKills(player.getKills());
        loggedPlayer.setDeaths(player.getDeaths());
        loggedPlayer.setStatisticGames(player.getStatisticGames());

        return loggedPlayer;
    }
}
