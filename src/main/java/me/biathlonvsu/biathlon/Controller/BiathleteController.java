package me.biathlonvsu.biathlon.Controller;

import lombok.RequiredArgsConstructor;
import me.biathlonvsu.biathlon.Service.BiathleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BiathleteController {

    private final BiathleteService biathleteService;

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/biathlete/{id}")
    public ResponseEntity<?> fetchBiathlete(@PathVariable int id){
        return ResponseEntity.ok(biathleteService.getBiathleteById(id));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/biathletes")
    public ResponseEntity<?> fetchBiathletes(){
        return ResponseEntity.ok(biathleteService.getAllBiathletes());
    }

}
