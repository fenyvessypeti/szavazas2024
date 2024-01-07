package com.example.szavazas2024.repository;

import com.example.szavazas2024.domain.Kepviselo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KepviseloRepository extends JpaRepository<Kepviselo, String> {
}
