package com.example.szavazas2024.controller;

import com.example.szavazas2024.domain.Kepviselo;
import com.example.szavazas2024.dto.KepviseloCommand;
import com.example.szavazas2024.service.KepviseloService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/szavazasok")
public class KepviseloController {

    private final KepviseloService kepviseloService;

    @Autowired
    public KepviseloController(KepviseloService kepviseloService) {
        this.kepviseloService = kepviseloService;
    }

    @PostMapping("/kepviselo")
    public ResponseEntity<String> letrehozKepviselo(@RequestBody KepviseloCommand kepviseloCommand, HttpServletRequest request) {
        System.out.println(kepviseloCommand);
        try {
            // Konvertálás a KepviseloCommand-ból Kepviselo objektummá (DTO -- > Entity)
            Kepviselo kepviselo = new Kepviselo();
            kepviselo.setKepviseloId(kepviseloCommand.getKepviseloId());
            kepviselo.setKepviseloNev(kepviseloCommand.getKepviseloNev());

            // Menti az új Kepviselo-t az adatbázisba
            kepviseloService.mentKepviselo(kepviselo);

            return new ResponseEntity<>("Kepviselo sikeresen létrehozva", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Hiba történt a Kepviselo létrehozása közben", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/kepviselo")
    public List<Kepviselo> getOsszesKepviselok() {
        return kepviseloService.getOsszesKepviselok();
    }

}

