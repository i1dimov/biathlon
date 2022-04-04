package me.biathlonvsu.biathlon.Repository;

import me.biathlonvsu.biathlon.Entity.Biathlete;
import me.biathlonvsu.biathlon.Entity.Competition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface BiathleteRepository extends CrudRepository<Biathlete, Integer> {

    Set<Biathlete> findAll();

}
