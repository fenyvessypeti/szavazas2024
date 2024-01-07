package com.example.szavazas2024.controller;

import com.example.szavazas2024.dto.SzavazasCommand;
import com.example.szavazas2024.service.SzavazasService;
import com.example.szavazas2024.service.SzavazatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/szavazasok")
public class SzavazasController {
    private final SzavazasService szavazasService;
    private final SzavazatService szavazatService;

    @Autowired
    public SzavazasController(SzavazasService szavazasService, SzavazatService szavazatService) {
        this.szavazasService = szavazasService;
        this.szavazatService = szavazatService;
    }

    @PostMapping("/szavazas")
    public ResponseEntity<String> letrehozSzavazas(@RequestBody SzavazasCommand szavazasCommand) {
        System.out.println("szavazasCommand: " + szavazasCommand);
        try {
            szavazasService.mentSzavazas(szavazasCommand);
            return new ResponseEntity<>("Szavazás létrehozása sikeres", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Hiba történt a Szavazás létrehozása közben", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
