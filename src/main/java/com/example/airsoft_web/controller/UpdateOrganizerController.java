package com.example.airsoft_web.controller;

import com.example.airsoft_web.models.dto.OrganizerDto;
import com.example.airsoft_web.models.entity.Organizer;
import com.example.airsoft_web.service.impl.OrganizerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UpdateOrganizerController {

    private final OrganizerServiceImpl organizerServiceImpl;

    public UpdateOrganizerController(OrganizerServiceImpl organizerServiceImpl) {
        this.organizerServiceImpl = organizerServiceImpl;
    }

    @GetMapping("/updateOrganizer")
    public ModelAndView updatePlayer(Model model) {

        model.addAttribute("organizer", new Organizer());
        return new ModelAndView("updateOrganizer");
    }

    @PostMapping("/updateOrganizer")
    public String updatePlayer(OrganizerDto organizerDto, HttpSession session) {

        Organizer updatePlayer = organizerServiceImpl.updateOrganizerInfo(organizerDto);

        session.setAttribute("loggedOrganizerAuthorization", updatePlayer);

        return "updateOrganizer";
    }
}
