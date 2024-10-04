package com.example.airsoft_web.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "equipments")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String helmet;

    @Column
    private String goggles;

    @Column
    private String gloves;

    @Column(name = "mouth_protector")
    private String mouthProtector;

    @Column
    private String radio;

    // TODO
    // Make it Riffle class in the future
    private String riffle;

    // TODO
    // Make it Pistol class in the future
    private String pistol;

    @OneToOne(mappedBy = "equipment")
    private Player player;
}

