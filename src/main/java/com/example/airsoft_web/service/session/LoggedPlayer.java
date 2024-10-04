package com.example.airsoft_web.service.session;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class LoggedPlayer {

    private int playedGames;

    private int kills;

    private int deaths;

    private double statisticGames;

//    private PlayerAuthorization playerAuthorisation;

//    private Equipment equipment;
}
