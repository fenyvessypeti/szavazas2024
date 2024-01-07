package com.example.szavazas2024.service;

import com.example.szavazas2024.domain.Szavazas;
import com.example.szavazas2024.domain.Szavazat;
import com.example.szavazas2024.dto.SzavazasCommand;
import com.example.szavazas2024.dto.SzavazatCommand;
import com.example.szavazas2024.repository.SzavazasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void mentSzavazas(SzavazasCommand szavazasCommand) {
        Szavazas szavazas = new Szavazas();
        szavazas.setIdopont(szavazasCommand.getIdopont());
        szavazas.setTargy(szavazasCommand.getTargy());
        szavazas.setTipus(szavazasCommand.getTipus());
        szavazas.setElnok(szavazasCommand.getElnok());
        if (szavazasEllenorzes(szavazasCommand)) {
            szavazasRepository.save(szavazas);

            for (SzavazatCommand szavazatCommand : szavazasCommand.getSzavazatok()) {
                Szavazat szavazat = new Szavazat();
                szavazat.setKepviselo(szavazatCommand.getKepviselo());
                szavazat.setSzavazat(szavazatCommand.getSzavazat());
                Szavazat mentettSzavazat = szavazatService.mentSzavazat(szavazat);
                szavazat.setSzavazas(szavazas);
            }
        }
    }

    private boolean szavazasEllenorzes(SzavazasCommand szavazasCommand) {
        boolean isSikeres = (isElnokSzavazott(szavazasCommand)&&isMegfeleloStrukturaju(szavazasCommand));
        return isSikeres;
    }

    private boolean isElnokSzavazott(SzavazasCommand szavazasCommand) {
        return szavazasCommand.getElnok() != null;
    }

    private boolean isMegfeleloStrukturaju(SzavazasCommand szavazasCommand) {
        return (szavazasCommand.getIdopont() != null && szavazasCommand.getTargy() != null &&
                szavazasCommand.getTipus() != null);
    }

}