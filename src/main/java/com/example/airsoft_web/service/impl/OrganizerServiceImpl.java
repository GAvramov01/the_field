package com.example.airsoft_web.service.impl;

import com.example.airsoft_web.models.dto.OrganizerDto;
import com.example.airsoft_web.models.entity.City;
import com.example.airsoft_web.models.entity.Organizer;
import com.example.airsoft_web.repository.CityRepository;
import com.example.airsoft_web.repository.OrganizerRepository;
import com.example.airsoft_web.service.OrganizerService;
import com.example.airsoft_web.service.session.LoggedOrganizer;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Service
public class OrganizerServiceImpl implements OrganizerService {

    private final PasswordEncoder passwordEncoder;
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;
    private final OrganizerRepository organizerRepository;
    private final LoggedOrganizer loggedOrganizer;

    public OrganizerServiceImpl(PasswordEncoder passwordEncoder, CityRepository cityRepository, ModelMapper modelMapper, OrganizerRepository organizerRepository, LoggedOrganizer loggedOrganizer) {
        this.passwordEncoder = passwordEncoder;
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
        this.organizerRepository = organizerRepository;
        this.loggedOrganizer = loggedOrganizer;
    }

    @Override
    public Organizer registerOrganizer(OrganizerDto organizerDto) {

        Organizer organizer = new Organizer();

        organizer.setFirstName(organizerDto.getFirstName());
        organizer.setLastName(organizerDto.getLastName());
        organizer.setPassword(passwordEncoder.encode(organizerDto.getPassword()));
        organizer.setEmail(organizerDto.getEmail());
        organizer.setCreateDateOrganizer(LocalDate.now());

        City city = cityRepository.findById(organizerDto.getCity().getId());
        organizer.setCity(city);

        organizer.setClubName(organizerDto.getClubName());

        modelMapper.map(organizer, Organizer.class);

        printOrganizer(organizer);

        return organizerRepository.save(organizer);
    }

    @Override
    public boolean loginOrganizer(OrganizerDto organizerDto, HttpSession session) {

        String emailOrganizator = organizerDto.getEmail();
        Organizer org = organizerRepository.findByEmail(emailOrganizator);

        if (org == null) {
            return false;
        }
        boolean matchingPassword = passwordEncoder.matches(organizerDto.getPassword(), org.getPassword());

        if (!matchingPassword) {
            throw new IllegalArgumentException("Password doesn't match");
        }

        session.setAttribute("loggedOrganizer", org);
        printOrganizer(org);

        return true;
    }

    @Override
    public Organizer getOrganizerById(Long id) {
        return organizerRepository.findById(id).orElse(null);
    }

    @Override
    public Organizer updateOrganizerInfo(OrganizerDto organizerDto) {

        Organizer existingOrganizer = organizerRepository.findByEmailAndPassword(organizerDto.getEmail(), organizerDto.getPassword());

        existingOrganizer.setFirstName(organizerDto.getFirstName());
        existingOrganizer.setLastName(organizerDto.getLastName());
        existingOrganizer.setEmail(organizerDto.getEmail());
        existingOrganizer.setClubName(organizerDto.getClubName());

        printOrganizer(existingOrganizer);

        return organizerRepository.save(existingOrganizer);
    }

    @Override
    public LoggedOrganizer printOrganizer(Organizer organizer) {

        loggedOrganizer.setFirstName(organizer.getFirstName());
        loggedOrganizer.setLastName(organizer.getLastName());
        loggedOrganizer.setEmail(organizer.getEmail());

        if (organizer.getCity() != null) {
            loggedOrganizer.setCity(organizer.getCity().getName());
        } else {
            loggedOrganizer.setCity(null);
        }

        loggedOrganizer.setClubName(organizer.getClubName());

        return loggedOrganizer;
    }
}
