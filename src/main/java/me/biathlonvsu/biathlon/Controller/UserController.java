package me.biathlonvsu.biathlon.Controller;

import io.swagger.v3.oas.annotations.Operation;
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
    @PostMapping("/register")// Регистрация
    @Operation(
            summary ="Регистрация пользователя",
            description ="Позволяет зарегестрировать пользователя"
    )
    public ResponseEntity<User> register(@RequestBody User user){
        return ResponseEntity.ok(userService.register(user.getLogin(), user.getPassword(), user.getName()));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @PostMapping("/login")
    @Operation(
            summary ="Авторизация пользователя",
            description ="Поозваоляет авторизовать пользователя"
    )
    public ResponseEntity<User> logIn(@RequestBody User user){
        return ResponseEntity.ok(userService.logIn(user.getLogin(), user.getPassword()));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @PostMapping("/changePassword")
    @Operation(
            summary ="Смена пароля",
            description ="Позволяет сменить пароль пользователя"
    )
    public ResponseEntity<Boolean> changeUserPassword(@RequestParam int userId, @RequestParam String newPassword){
        return ResponseEntity.ok(userService.changePassword(userId, newPassword));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @PostMapping("/subscribeToBiathlete")
    @Operation(
            summary ="Подписаться на биатлониста",
            description ="Позволяет подписаться на биатлониста"
    )
    public ResponseEntity<Boolean> subscribeToBiathlete(@RequestParam int userId,@RequestParam int biathleteId){
        return ResponseEntity.ok(userService.subscribeToBiathlete(userId, biathleteId));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @PostMapping("/subscribeToCompetition")
    @Operation(
            summary ="Подписаться на соревнование",
            description ="Позволяет подписаться на соревнование"
    )
    public ResponseEntity<Boolean> subscribeToCompetition(@RequestParam int userId,@RequestParam int competitionId){
        return ResponseEntity.ok(userService.subscribeToCompetition(userId, competitionId));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @PostMapping("/unsubscribeFromBiathlete")
    @Operation(
            summary ="Отписаться от биатлониста",
            description ="Позволяет отписаться от биатлониста"
    )
    public ResponseEntity<Boolean> unsubscribeFromBiathlete(@RequestParam int userId,@RequestParam int biathleteId){
        return ResponseEntity.ok(userService.unsubscribeFromBiathlete(userId, biathleteId));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @PostMapping("/unsubscribeFromCompetition")
    @Operation(
            summary ="Отписаться от соревнования",
            description ="Позволяет отписаться от соревнования"
    )
    public ResponseEntity<Boolean> unsubscribeFromCompetition(@RequestParam int userId,@RequestParam int competitionId){
        return ResponseEntity.ok(userService.unsubscribeFromCompetition(userId, competitionId));
    }

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/allSubscribeCompetitions")
    @Operation(
            summary ="Просмотр соревнования в подписках",
            description ="Позволяет просмотреть соревнования на которые подписан пользователь"
    )
    public ResponseEntity<Set<Competition>> getAllSubscribeCompetition(@RequestParam int userId){
        return ResponseEntity.ok(userService.getAllSubscribeCompetitions(userId));
    }//соревнования на которые подписался юзер

    @CrossOrigin(origins = "http://localhost:63342")//для фронта в идеи
    @GetMapping("/allSubscribeCompetitionsWithBiathletes")
    @Operation(
            summary ="Просмотр биатлонистов в подписках",
            description ="Позволяет просмореть биатлонистов на которых подписан пользователь"
    )
    public ResponseEntity<Set<Competition>> getAllCompetitionsSubscribeWithBiathletes(@RequestParam int userId){
        return ResponseEntity.ok(userService.getAllCompetitionsSubscribeWithBiathletes(userId));
    }//соревнования в которых учавствует биатлонисты, на которых подписался юзер

}
