package com.example.airsoft_web.repository;

import com.example.airsoft_web.models.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByName(String name);

    @Query("SELECT c FROM City c WHERE c.id = :id")
    City findById(@Param("id") long id);
//    City findAllById(long id);

    List<City> findAllByOrderByNameAsc();

    List<City> findAll();
}
