package com.example.szavazas2024.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SzavazasCommand {
    private String idopont;
    private String targy;
    private String tipus;
    private String elnok;
    private List<SzavazatCommand> szavazatok;
}