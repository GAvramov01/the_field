package com.example.airsoft_web.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "cities")
public class City extends BaseEntity {

    @Column
    private String name;

    @Column
    private String lat;

    @Column
    private String lng;

    @Column
    private String country;

    @Column
    private String iso;

    @Column
    private String region;

    @Column
    private String capital;

    @Column
    private String population;

    @Column(name = "population_proper")
    private String populationProper;

    @OneToOne(mappedBy = "city")
    private PlayerAuthorization playerAuthorisation;

    @OneToOne(mappedBy = "city")
    private Organizer organizer;

    @OneToOne(mappedBy = "city")
    private Tournament tournament;
}