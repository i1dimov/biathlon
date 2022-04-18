package me.biathlonvsu.biathlon.Controller;

import lombok.RequiredArgsConstructor;
import me.biathlonvsu.biathlon.Entity.Biathlete;
import me.biathlonvsu.biathlon.Service.BiathleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class BiathleteController {

    private final BiathleteService biathleteService;

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/biathlete")
    public ResponseEntity<Biathlete> fetchBiathlete(@RequestParam int id){
        return ResponseEntity.ok(biathleteService.getBiathleteById(id));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/biathletes")
    public ResponseEntity<Set<Biathlete>> fetchBiathletes(){
        return ResponseEntity.ok(biathleteService.getAllBiathletes());
    }

}
