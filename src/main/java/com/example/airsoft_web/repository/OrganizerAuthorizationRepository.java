package com.example.airsoft_web.repository;

import com.example.airsoft_web.models.entity.OrganizerAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerAuthorizationRepository extends JpaRepository<OrganizerAuthorization, Long> {
}
