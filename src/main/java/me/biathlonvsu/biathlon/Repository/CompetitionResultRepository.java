package me.biathlonvsu.biathlon.Repository;

import me.biathlonvsu.biathlon.Entity.CompetitionResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionResultRepository extends CrudRepository<CompetitionResult, Integer> {
}
