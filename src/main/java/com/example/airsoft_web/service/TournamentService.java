package com.example.airsoft_web.service;

import com.example.airsoft_web.models.dto.TournamentDto;
import com.example.airsoft_web.models.entity.Organizer;
import com.example.airsoft_web.models.entity.Tournament;

import java.util.List;

public interface TournamentService {

    public Tournament registerTournament(TournamentDto tournamentDto, Organizer organizer);

    public List<Tournament> getAllTournaments();
}
