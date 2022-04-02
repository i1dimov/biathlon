package me.biathlonvsu.biathlon.Repository;

import me.biathlonvsu.biathlon.Entity.Competition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CompetitionRepository extends CrudRepository<Competition, Integer> {

    Set<Competition> findAll();

}