package me.biathlonvsu.biathlon.Controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import me.biathlonvsu.biathlon.Entity.Competition;
import me.biathlonvsu.biathlon.Service.CompetitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionService competitionService;

    @CrossOrigin()//для фронта в идеи
    @GetMapping("/competition")
    @Operation(
            summary ="Просмотр соревнования",
            description ="Позволяет просмотреть соревновыание по ID"
    )
    public ResponseEntity<Competition> fetchCompetition(@RequestParam int id) {
        return ResponseEntity.ok(competitionService.getCompetitionById(id));
    }

    @CrossOrigin()//для фронта в идеи
    @GetMapping("/competitions")
    @Operation(
            summary ="Просмотр всех соревнований",
            description ="Позволяет просмотреть все соревнования"
    )
    public ResponseEntity<Set<Competition>> fetchCompetitions() {
        return ResponseEntity.ok(competitionService.getAllCompetitions());
    }
}