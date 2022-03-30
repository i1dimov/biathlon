package me.biathlonvsu.biathlon.Repository;

import me.biathlonvsu.biathlon.Entity.Competition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends CrudRepository<Competition, Integer> {

}