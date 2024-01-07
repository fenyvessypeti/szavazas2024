package com.example.szavazas2024.service;

import com.example.szavazas2024.domain.Kepviselo;
import com.example.szavazas2024.repository.KepviseloRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class KepviseloService {

    private final KepviseloRepository kepviseloRepository;

    @Autowired
    public KepviseloService(KepviseloRepository kepviseloRepository) {
        this.kepviseloRepository = kepviseloRepository;
    }

    public void mentKepviselo(Kepviselo kepviselo) {
        kepviseloRepository.save(kepviselo);
    }

    public List<Kepviselo> getOsszesKepviselok() {
        return kepviseloRepository.findAll();
    }
}

