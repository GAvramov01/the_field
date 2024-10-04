package com.example.airsoft_web.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "players")
public class Player extends BaseEntity {

    @Column(name = "played_games")
    private int playedGames;

    @Column
    private int kills;

    @Column
    private int deaths;

    @Column
    private double statisticGames;

    @OneToOne(mappedBy = "player")
    private PlayerAuthorization playerAuthorisation;

    @OneToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
}
