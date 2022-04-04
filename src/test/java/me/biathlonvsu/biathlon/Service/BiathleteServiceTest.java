package me.biathlonvsu.biathlon.Service;

import me.biathlonvsu.biathlon.Entity.Biathlete;
import me.biathlonvsu.biathlon.Entity.Competition;
import me.biathlonvsu.biathlon.Repository.BiathleteRepository;
import me.biathlonvsu.biathlon.Repository.CompetitionRepository;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class BiathleteServiceTest {

    @MockBean
    private BiathleteRepository biathleteRepository;

    @InjectMocks
    private BiathleteService biathleteService;

    private Biathlete biathlete = createTestBiathlete();

    private Biathlete createTestBiathlete() {
        Biathlete biathlete = new Biathlete();
        biathlete.setId(1);
        biathlete.setName("Мартен");
        biathlete.setSecondName("Фуркад");
        biathlete.setGender(Gender.MAN);
        biathlete.setBirthDate(new Date(88, 9, 14));
        biathlete.setCompetitionResults(new HashSet<>());
        return biathlete;
    }

    @Test
    void getAllBiathletes() {
        createMockito();
        Set<Biathlete> biathletes = biathleteService.getAllBiathletes();
        assertEquals(biathletes.size(), 1);
        assertEquals(biathletes.stream().findFirst().get().getId(), 1);

    }

    @Test
    void getBiathleteById() {
        createMockito();
        Biathlete biathlete = biathleteService.getBiathleteById(1);
        assertEquals(biathlete.getName(), "Мартен");
        Biathlete biathlete2 = biathleteService.getBiathleteById(-1);
        assertNull(biathlete2);
    }

    private void createMockito(){
        Mockito.when(biathleteRepository.findById(biathlete.getId())).thenReturn(java.util.Optional.of(biathlete));
        HashSet<Biathlete> biathletes = new HashSet<>();
        biathletes.add(biathlete);
        Mockito.when(biathleteRepository.findAll()).thenReturn(biathletes);
    }
}