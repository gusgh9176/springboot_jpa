package com.example.webservice.domain.materials;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface MaterialsRepository extends JpaRepository<Materials, Long> {

    @Query("SELECT m " +
            "FROM Materials m " +
            "ORDER BY m.id DESC")
    Stream<Materials> findAllDesc();

    Stream<Materials> findByClassification(String material);


}
