package me.biathlonvsu.biathlon.Controller;


import lombok.RequiredArgsConstructor;
import me.biathlonvsu.biathlon.Entity.Competition;
import me.biathlonvsu.biathlon.Service.CompetitionService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionService competitionService;

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/competition")
    public ResponseEntity<Competition> fetchCompetition(@RequestParam int id) {
        return ResponseEntity.ok(competitionService.getCompetitionById(id));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/competitions")
    public ResponseEntity<Set<Competition>> fetchCompetitions() {
        return ResponseEntity.ok(competitionService.getAllCompetitions());
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("biathlon/front/")
    public ResponseEntity<Set<Competition>> fetchHome() {
        return ResponseEntity.ok(competitionService.getAllCompetitions());
    }
}
