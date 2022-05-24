package me.biathlonvsu.biathlon.Controller;
import io.swagger.v3.oas.annotations.Operation;
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

    @CrossOrigin()//для фронта в идеи
    @GetMapping("/biathlete")
    @Operation(
            summary ="Просмотр биатлониста",
            description ="Позволяет получить биатлониста по ID"
    )
    public ResponseEntity<Biathlete> fetchBiathlete(@RequestParam int id){
        return ResponseEntity.ok(biathleteService.getBiathleteById(id));
    }

    @CrossOrigin()//для фронта в идеи
    @GetMapping("/biathletes")
    @Operation(
            summary ="Просмотр всех биатлонистов",
            description ="Позволяет получить всех биатлонистов"
    )
    public ResponseEntity<Set<Biathlete>> fetchBiathletes(){
        return ResponseEntity.ok(biathleteService.getAllBiathletes());
    }
}