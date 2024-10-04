package com.example.airsoft_web.repository;

import com.example.airsoft_web.models.entity.PlayerAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerAuthorizationRepository extends JpaRepository<PlayerAuthorization, Long> {

    PlayerAuthorization findByLastName(String lastName);
}
