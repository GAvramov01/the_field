package com.example.airsoft_web.repository;

import com.example.airsoft_web.models.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

//    Optional<City> findById(Long aLong);

    City findByName(String name);

    City findById(long id);

    List<City> findAllByOrderByNameAsc();
}
