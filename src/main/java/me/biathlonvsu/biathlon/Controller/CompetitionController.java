package me.biathlonvsu.biathlon.Controller;


import lombok.RequiredArgsConstructor;
import me.biathlonvsu.biathlon.Service.CompetitionService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompetitionController {

    private final CompetitionService competitionService;

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/competition/{id}")
    public ResponseEntity<?> fetchCompetition(@PathVariable int id) {
        return ResponseEntity.ok(competitionService.getCompetitionById(id));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/competitions")
    public ResponseEntity<?> fetchCompetitions() {
        return ResponseEntity.ok(competitionService.getAllCompetitions());
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("biathlon/front/")
    public ResponseEntity<?> fetchHome() {
        return ResponseEntity.ok(competitionService.getAllCompetitions());
    }
}
