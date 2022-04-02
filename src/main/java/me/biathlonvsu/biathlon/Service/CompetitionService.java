package me.biathlonvsu.biathlon.Service;

import me.biathlonvsu.biathlon.Entity.Competition;
import me.biathlonvsu.biathlon.Repository.CompetitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    public Set<Competition> getAllCompetitions(){
        return competitionRepository.findAll();
    }

    public Competition getCompetitionById(int id){
        Optional<Competition> competition = competitionRepository.findById(id);
        return competition.orElse(null);
    }
}
