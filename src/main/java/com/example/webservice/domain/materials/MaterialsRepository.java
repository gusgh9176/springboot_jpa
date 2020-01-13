package com.example.webservice.domain.materials;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface MaterialsRepository extends JpaRepository<Materials, Long> {
    @Query("SELECT m " +
            "FROM Materials m " +
            "ORDER BY m.id DESC")
    Stream<Materials> findAllDesc();

    @Query("SELECT m " +
            "FROM Materials m " +
            "WHERE m.classification LIKE '%골조%'")
    Stream<Materials> findSkeleton();

    @Query("SELECT m " +
            "FROM Materials m " +
            "WHERE m.classification LIKE '%단열%'")
    Stream<Materials> findInsulation();

    @Query("SELECT m " +
            "FROM Materials m " +
            "WHERE m.classification LIKE '%외장마감%'")
    Stream<Materials> findExterior();

    @Query("SELECT m " +
            "FROM Materials m " +
            "WHERE m.classification LIKE '%내장마감%'")
    Stream<Materials> findInterior();

    @Query("SELECT m " +
            "FROM Materials m " +
            "WHERE m.classification LIKE '%창호%'")
    Stream<Materials> findWindow();
}
