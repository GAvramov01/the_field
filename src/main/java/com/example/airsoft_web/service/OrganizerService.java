package com.example.airsoft_web.service;

import com.example.airsoft_web.models.dto.OrganizerDto;
import com.example.airsoft_web.models.entity.Organizer;
import com.example.airsoft_web.service.session.LoggedOrganizer;

import javax.servlet.http.HttpSession;

public interface OrganizerService {

    public Organizer registerOrganizer(OrganizerDto organizerDto);

    public LoggedOrganizer printOrganizer(Organizer organizer);

    public boolean loginOrganizer(OrganizerDto organizerDto, HttpSession session);

    public Organizer getOrganizerById(Long id);

    public Organizer updateOrganizerInfo(OrganizerDto organizerDto);

}
