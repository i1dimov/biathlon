package me.biathlonvsu.biathlon.Service;

import me.biathlonvsu.biathlon.Entity.Competition;
import me.biathlonvsu.biathlon.Repository.CompetitionRepository;
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

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class CompetitionServiceTest {

    @MockBean
    private CompetitionRepository competitionRepository;

    @InjectMocks
    private CompetitionService competitionService;

    private Competition competition = createTestCompetition();

    @Test
    void getAllCompetitions() {
        createMockito();
        Set<Competition> competitions = competitionService.getAllCompetitions();
        assertEquals(competitions.size(), 1);
        assertEquals(competitions.stream().findFirst().get().getId(), 1);
    }

    @Test
    void getCompetitionById() {
        createMockito();
        Competition competition = competitionService.getCompetitionById(1);
        assertEquals(competition.getName(), "Кубок мира");
        Competition competition2 = competitionService.getCompetitionById(-1);
        assertNull(competition2);
    }

    private Competition createTestCompetition(){
        Competition competition = new Competition();
        competition.setId(1);
        competition.setName("Кубок мира");
        competition.setLocation("Швеция");
        competition.setDate(new Date(117, 11, 26));
        return competition;
    }

    private void createMockito(){
        Mockito.when(competitionRepository.findById(competition.getId())).thenReturn(java.util.Optional.of(competition));
        HashSet<Competition> competitions = new HashSet<>();
        competitions.add(competition);
        Mockito.when(competitionRepository.findAll()).thenReturn(competitions);
    }
}