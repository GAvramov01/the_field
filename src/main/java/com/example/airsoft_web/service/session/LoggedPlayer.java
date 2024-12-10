package com.example.airsoft_web.service.session;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@Component
@SessionScope
public class LoggedPlayer {

    private int playedGames;
    private int kills;
    private int deaths;
    private double statisticGames;

}
