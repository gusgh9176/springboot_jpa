package com.example.webservice.domain.materials;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface MaterialsRepository extends JpaRepository<Materials, Long> {
    @Query("SELECT p " +
            "FROM Materials p " +
            "ORDER BY p.id DESC")
    Stream<Materials> findAllDesc();
}