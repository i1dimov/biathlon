package me.biathlonvsu.biathlon.Entity;

import me.biathlonvsu.biathlon.Repository.BiathleteRepository;
import me.biathlonvsu.biathlon.Repository.CompetitionRepository;
import me.biathlonvsu.biathlon.Repository.UserRepository;
import me.biathlonvsu.biathlon.SupportingTools.Gender;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void getAndSetUserBiathletes() {
        Biathlete biathlete = new Biathlete();
        biathlete.setId(1);
        biathlete.setName("Мартен");
        biathlete.setSecondName("Фуркад");
        biathlete.setGender(Gender.MAN);
        biathlete.setBirthDate(new Date(1988, 9, 14));
        entityManager.persist(biathlete);
        entityManager.flush();

        User user = new User();
        user.setName("admin");
        user.setLogin("admin");
        user.setId(2);
        user.setPassword(2);
        Set<Biathlete> newBiathletes = new HashSet<>();
        user.setBiathletes(newBiathletes);
        user.getBiathletes().add(biathlete);
        entityManager.persist(user);
        entityManager.flush();

        User user1 = userRepository.findById(2).get();
        Set<Biathlete> biathletes = user1.getBiathletes();
        Biathlete biathlete1 = biathletes.stream().findFirst().get();
        assertEquals(biathlete1.getId(), 1);
        assertEquals(biathlete1.getName(), "Мартен");
        assertEquals(biathlete1.getSecondName(), "Фуркад");
        assertEquals(biathlete1.getGender(), Gender.MAN);
        assertEquals(biathlete1.getBirthDate(), new Date(1988, 9, 14));

    }

    @Test
    public void getAndSetUserCompetitions() {
        Competition competition = new Competition();
        competition.setId(1);
        competition.setName("Кубок мира");
        competition.setLocation("Швеция");
        competition.setDate(new Date(2017, 11, 26));
        entityManager.persist(competition);
        entityManager.flush();

        User user = new User();
        user.setName("admin");
        user.setLogin("admin");
        user.setId(2);
        user.setPassword(2);
        Set<Competition> competitions1 = new HashSet<>();
        user.setCompetitions(competitions1);
        user.getCompetitions().add(competition);
        entityManager.persist(user);
        entityManager.flush();

        User user1 = userRepository.findById(2).get();
        Set<Competition> competitions = user1.getCompetitions();
        Competition competition1 = competitions.stream().findFirst().get();
        assertEquals(competition1.getId(), 1);
        assertEquals(competition1.getName(), "Кубок мира");
        assertEquals(competition1.getLocation(), "Швеция");
        assertEquals(competition1.getDate(), new Date(2017, 11, 26));
    }
}