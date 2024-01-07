package com.example.szavazas2024.service;

import com.example.szavazas2024.repository.SzavazasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SzavazasService {
    private final SzavazasRepository szavazasRepository;
    private final SzavazatService szavazatService;

    @Autowired
    public SzavazasService(SzavazasRepository szavazasRepository, SzavazatService szavazatService) {
        this.szavazasRepository = szavazasRepository;
        this.szavazatService = szavazatService;
    }
}

