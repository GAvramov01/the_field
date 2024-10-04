package com.example.airsoft_web.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tournaments")
public class Tournament extends BaseEntity {

    @Column(nullable = false)
    private int players;

    @Column(name = "new_player", nullable = false)
    private int newPlayers;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column
    private String coordinates;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne(mappedBy = "tournament")
    private Organizer organizer;
}
