package me.biathlonvsu.biathlon.Service;

import me.biathlonvsu.biathlon.Entity.Biathlete;
import me.biathlonvsu.biathlon.Entity.Competition;
import me.biathlonvsu.biathlon.Entity.CompetitionResult;
import me.biathlonvsu.biathlon.Entity.User;
import me.biathlonvsu.biathlon.Repository.BiathleteRepository;
import me.biathlonvsu.biathlon.Repository.CompetitionRepository;
import me.biathlonvsu.biathlon.Repository.UserRepository;
import me.biathlonvsu.biathlon.SupportingTools.CompetitionResultKey;
import me.biathlonvsu.biathlon.SupportingTools.Gender;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private BiathleteRepository biathleteRepository;

    @MockBean
    private CompetitionRepository competitionRepository;

    @InjectMocks
    private UserService userService;

    private Biathlete biathlete = createTestBiathlete();
    private Competition competition = createTestCompetition();
    private User user = createTestUser();

    @Test
    void subscribeToBiathlete() {
        createMockito();
        createTestCompetitionResult();
        boolean tr = userService.subscribeToBiathlete(user.getId(), biathlete.getId());
        assertTrue(tr);
        assertEquals(userRepository.findById(user.getId()).get().getBiathletes().stream().findFirst().get().getId(), biathlete.getId());
        boolean fl = userService.subscribeToBiathlete(-1, biathlete.getId());
        assertFalse(fl);
        boolean fl1 = userService.subscribeToBiathlete(user.getId(), -1);
        assertFalse(fl1);
    }

    @Test
    void subscribeToCompetition() {
        createMockito();
        boolean tr = userService.subscribeToCompetition(user.getId(), competition.getId());
        assertTrue(tr);
        assertEquals(userRepository.findById(user.getId()).get().getCompetitions().stream().findFirst().get().getId(), competition.getId());
        boolean fl = userService.subscribeToCompetition(-1, competition.getId());
        assertFalse(fl);
        boolean fl1 = userService.subscribeToCompetition(user.getId(), -1);
        assertFalse(fl1);
    }

    @Test
    void unsubscribeFromBiathlete() {
        createMockito();
        createTestCompetitionResult();
        userService.subscribeToBiathlete(user.getId(), biathlete.getId());
        boolean tr = userService.unsubscribeFromBiathlete(user.getId(), biathlete.getId());
        assertTrue(tr);
        assertEquals(userRepository.findById(user.getId()).get().getBiathletes().size(), 0);
        boolean fl = userService.unsubscribeFromBiathlete(-1, biathlete.getId());
        assertFalse(fl);
        boolean fl1 = userService.unsubscribeFromBiathlete(user.getId(), -1);
        assertFalse(fl1);
    }

    @Test
    void unsubscribeFromCompetition() {
        createMockito();
        userService.subscribeToCompetition(user.getId(), competition.getId());
        boolean tr = userService.unsubscribeFromCompetition(user.getId(), competition.getId());
        assertTrue(tr);
        assertEquals(userRepository.findById(user.getId()).get().getCompetitions().size(), 0);
        boolean fl = userService.unsubscribeFromCompetition(-1, competition.getId());
        assertFalse(fl);
        boolean fl1 = userService.unsubscribeFromCompetition(user.getId(), -1);
        assertFalse(fl1);
    }

    @Test
    void getAllSubscribeCompetition() {
        createMockito();
        userService.subscribeToCompetition(user.getId(), competition.getId());
        Set<Competition> competitions = userService.getAllSubscribeCompetitions(user.getId());
        assertEquals(competitions.size(), 1);
        assertEquals(competitions.stream().findFirst().get().getId(), competition.getId());
        Set<Competition> nl = userService.getAllSubscribeCompetitions(-1);
        assertNull(nl);
    }

    @Test
    void getAllCompetitionSubscribeWithBiathletes() {
        createMockito();
        userService.subscribeToBiathlete(user.getId(), biathlete.getId());
        userService.subscribeToCompetition(user.getId(), competition.getId());
        createTestCompetitionResult();
        Set<Competition> competitions = userService.getAllCompetitionsSubscribeWithBiathletes(2);
        assertEquals(competitions.size(), 1);
        assertEquals(competitions.stream().findFirst().get().getId(), competition.getId());
        Set<Competition> nl = userService.getAllSubscribeCompetitions(-1);
        assertNull(nl);
    }

    @Test
    void register() {
        createMockito();
        User user = userService.register("cap4ick", "11", "Сергей");
        assertEquals(user.getName(),"Сергей");
        User nl = userService.register("admin", "11", "Сергей");
        assertNull(nl);
    }

    @Test
    void logIn() {
        createMockito();
        User user = userService.logIn("admin", "11");
        assertEquals(user.getId(),2);
        User user2 = userService.logIn("admin", "12");
        assertNull(user2);
        User user3 = userService.logIn("admi", "11");
        assertNull(user3);
    }

    @Test
    void changePassword() {
        createMockito();
        boolean tr = userService.changePassword(2, "12");
        assertTrue(tr);
        assertEquals(userRepository.findById(user.getId()).get().getPassword(), "12".hashCode());
        boolean fl = userService.changePassword(3, "12");
        assertFalse(fl);
    }


    private void createMockito(){
        Mockito.when(userRepository.findById(user.getId())).thenReturn(java.util.Optional.of(user));
        Mockito.when(userRepository.findByLogin(user.getLogin())).thenReturn(java.util.Optional.of(user));
        Mockito.when(biathleteRepository.findById(biathlete.getId())).thenReturn(java.util.Optional.of(biathlete));
        Mockito.when(competitionRepository.findById(competition.getId())).thenReturn(java.util.Optional.of(competition));
    }

    private User createTestUser(){
        User user = new User();
        user.setName("admin");
        user.setLogin("admin");
        user.setId(2);
        String password = "11";
        user.setPassword(password.hashCode());
        Set<Biathlete> biathletes = new HashSet<>();
        user.setBiathletes(biathletes);
        Set<Competition> competitions = new HashSet<>();
        user.setCompetitions(competitions);
        return user;
    }

    private Biathlete createTestBiathlete(){
        Biathlete biathlete = new Biathlete();
        biathlete.setId(1);
        biathlete.setName("Мартен");
        biathlete.setSecondName("Фуркад");
        biathlete.setGender(Gender.MAN);
        biathlete.setBirthDate(new Date(88, 9, 14));
        biathlete.setCompetitionResults(new HashSet<>());
        return biathlete;
    }

    private Competition createTestCompetition(){
        Competition competition = new Competition();
        competition.setId(1);
        competition.setName("Кубок мира");
        competition.setLocation("Швеция");
        competition.setDate(new Date(117, 11, 26));
        return competition;
    }

    private CompetitionResult createTestCompetitionResult(){
        CompetitionResult competitionResult = new CompetitionResult();
        CompetitionResultKey competitionResultKey = new CompetitionResultKey();
        competitionResultKey.setBiathleteId(1);
        competitionResultKey.setCompetitionId(1);
        competitionResult.setId(competitionResultKey);
        competitionResult.setScore(60);
        competitionResult.setBiathlete(createTestBiathlete());
        competitionResult.setCompetition(createTestCompetition());
        HashSet<CompetitionResult> competitionResults = new HashSet<>();
        competitionResults.add(competitionResult);
        competition.setCompetitionResults(competitionResults);
        biathlete.setCompetitionResults(competitionResults);
        return competitionResult;
    }
}