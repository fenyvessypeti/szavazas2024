package com.example.szavazas2024.repository;

import com.example.szavazas2024.domain.Szavazat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SzavazatRepository extends JpaRepository<Szavazat, Long> {
}