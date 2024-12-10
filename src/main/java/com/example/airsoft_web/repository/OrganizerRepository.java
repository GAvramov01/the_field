package com.example.airsoft_web.repository;

import com.example.airsoft_web.models.entity.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

    Organizer findByEmail(String email);

    Organizer findById(long id);

    Organizer findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);
}
