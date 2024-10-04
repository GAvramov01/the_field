package com.example.airsoft_web.models.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "organizers")
public class Organizer extends BaseEntity {

    @Column(name = "club_name", nullable = false)
    private String clubName;

    @Column
    private int rate;

    @OneToOne(mappedBy = "organizer")
    private OrganizerAuthorization organizerAuthorization;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;

    @OneToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;
}
