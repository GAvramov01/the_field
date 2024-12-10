package com.example.airsoft_web.models.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "tournaments")
public class Tournament extends BaseEntity {

    @Column(name = "tournament_name")
    private String tournamentName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column
    private String coordinates;

    @DateTimeFormat(pattern = "HH:mm")
    @Column
    private LocalTime measurement;

    @DateTimeFormat(pattern = "HH:mm")
    @Column
    private LocalTime briefing;

    @Column
    private double price;

    @Column
    private String info;

    @Column(nullable = false)
    private int players;

    @Column(name = "new_player", nullable = false)
    private int newPlayers;

    @Column(name = "create_date_tournament", nullable = false)
    private LocalDate createDateTournament;

    @ManyToOne
    private City city;

    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false)
    private Organizer organizer;
}
