package com.example.szavazas2024.service;

import com.example.szavazas2024.domain.Szavazat;
import com.example.szavazas2024.repository.SzavazatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SzavazatService {
    private final SzavazatRepository szavazatRepository;

    @Autowired
    public SzavazatService(SzavazatRepository szavazatRepository) {
        this.szavazatRepository = szavazatRepository;
    }

    public Szavazat mentSzavazat(Szavazat szavazat) {
        System.out.println("Szavazatunk: "+szavazat);
        return szavazatRepository.save(szavazat);
    }

}
