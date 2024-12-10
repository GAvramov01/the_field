package com.example.airsoft_web.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "organizers")
public class Organizer extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false, unique = true)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "club_name", nullable = false)
    private String clubName;

    @Column
    private int rate;

    @Column(name = "create_date_organizer", nullable = false)
    private LocalDate createDateOrganizer;

    @ManyToOne
    @JoinColumn(name = "cities_id")
    private City city;

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL)
    private List<Tournament> tournaments;
}
