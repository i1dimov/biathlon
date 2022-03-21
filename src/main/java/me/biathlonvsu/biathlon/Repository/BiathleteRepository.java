package me.biathlonvsu.biathlon.Repository;

import me.biathlonvsu.biathlon.Entity.Biathlete;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BiathleteRepository extends CrudRepository<Biathlete, Long> {

}
