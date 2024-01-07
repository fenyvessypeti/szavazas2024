package com.example.szavazas2024.controller;

import com.example.szavazas2024.service.SzavazasService;
import com.example.szavazas2024.service.SzavazatService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
