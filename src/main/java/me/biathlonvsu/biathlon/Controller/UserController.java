package me.biathlonvsu.biathlon.Controller;

import lombok.RequiredArgsConstructor;
import me.biathlonvsu.biathlon.Entity.Competition;
import me.biathlonvsu.biathlon.Entity.User;
import me.biathlonvsu.biathlon.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        return ResponseEntity.ok(userService.register(user.getLogin(), user.getPassword(), user.getName()));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/login")
    public ResponseEntity<User> logIn(@RequestBody User user){
        return ResponseEntity.ok(userService.logIn(user.getLogin(), user.getPassword()));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/changePassword")
    public ResponseEntity<Boolean> changeUserPassword(@RequestParam int userId, @RequestParam String newPassword){
        return ResponseEntity.ok(userService.changePassword(userId, newPassword));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/subscribeToBiathlete")
    public ResponseEntity<Boolean> subscribeToBiathlete(@RequestParam int userId,@RequestParam int biathleteId){
        return ResponseEntity.ok(userService.subscribeToBiathlete(userId, biathleteId));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/subscribeToCompetition")
    public ResponseEntity<Boolean> subscribeToCompetition(@RequestParam int userId,@RequestParam int competitionId){
        return ResponseEntity.ok(userService.subscribeToCompetition(userId, competitionId));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/unsubscribeFromBiathlete")
    public ResponseEntity<Boolean> unsubscribeFromBiathlete(@RequestParam int userId,@RequestParam int biathleteId){
        return ResponseEntity.ok(userService.unsubscribeFromBiathlete(userId, biathleteId));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/unsubscribeFromCompetition")
    public ResponseEntity<Boolean> unsubscribeFromCompetition(@RequestParam int userId,@RequestParam int competitionId){
        return ResponseEntity.ok(userService.unsubscribeFromCompetition(userId, competitionId));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/allSubscribeCompetitions")
    public ResponseEntity<Set<Competition>> getAllSubscribeCompetition(@RequestParam int userId){
        return ResponseEntity.ok(userService.getAllSubscribeCompetitions(userId));
    }//соревнования на которые подписался юзер

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/allSubscribeCompetitionsWithBiathletes")
    public ResponseEntity<Set<Competition>> getAllCompetitionsSubscribeWithBiathletes(@RequestParam int userId){
        return ResponseEntity.ok(userService.getAllCompetitionsSubscribeWithBiathletes(userId));
    }//соревнования в которых учавствует биатлонисты, на которых подписался юзер

}
