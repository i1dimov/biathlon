package me.biathlonvsu.biathlon.Controller;

import lombok.RequiredArgsConstructor;
import me.biathlonvsu.biathlon.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/register/{login}/{password}/{name}")
    public ResponseEntity<?> register(@PathVariable String login,@PathVariable String password,@PathVariable String name){
        return ResponseEntity.ok(userService.register(login, password, name));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/login/{login}/{password}")
    public ResponseEntity<?> logIn(@PathVariable String login,@PathVariable String password){
        return ResponseEntity.ok(userService.logIn(login, password));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/changePassword/{userId}/{newPassword}")
    public ResponseEntity<?> changeUserPassword(@PathVariable int userId,@PathVariable String newPassword){
        return ResponseEntity.ok(userService.changePassword(userId, newPassword));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/subscribeToBiathlete/{userId}/{biathleteId}")
    public ResponseEntity<?> subscribeToBiathlete(@PathVariable int userId,@PathVariable int biathleteId){
        return ResponseEntity.ok(userService.subscribeToBiathlete(userId, biathleteId));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/subscribeToCompetition/{userId}/{competitionId}")
    public ResponseEntity<?> subscribeToCompetition(@PathVariable int userId,@PathVariable int competitionId){
        return ResponseEntity.ok(userService.subscribeToCompetition(userId, competitionId));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/unsubscribeFromBiathlete/{userId}/{biathleteId}")
    public ResponseEntity<?> unsubscribeFromBiathlete(@PathVariable int userId,@PathVariable int biathleteId){
        return ResponseEntity.ok(userService.unsubscribeFromBiathlete(userId, biathleteId));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/unsubscribeFromCompetition/{userId}/{competitionId}")
    public ResponseEntity<?> unsubscribeFromCompetition(@PathVariable int userId,@PathVariable int competitionId){
        return ResponseEntity.ok(userService.unsubscribeFromCompetition(userId, competitionId));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/allSubscribeCompetitions/{userId}")
    public ResponseEntity<?> getAllSubscribeCompetition(@PathVariable int userId){
        return ResponseEntity.ok(userService.getAllSubscribeCompetitions(userId));
    }//соревнования на которые подписался юзер

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/allSubscribeCompetitionsWithBiathletes/{userId}")
    public ResponseEntity<?> getAllCompetitionsSubscribeWithBiathletes(@PathVariable int userId){
        return ResponseEntity.ok(userService.getAllCompetitionsSubscribeWithBiathletes(userId));
    }//соревнования в которых учавствует биатлонисты, на которых подписался юзер

}
