package com.example.airsoft_web.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Data
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

    @OneToMany(mappedBy = "city")
    private List<PlayerAuthorization> playerAuthorisation;

    //    @ManyToOne
//    @JoinColumn(name = "cities")
//    private Organizer organizer;
    @OneToMany(mappedBy = "city")
    private List<Organizer> organizers;

    @OneToMany(mappedBy = "city")
    private List<Tournament> tournament;
}