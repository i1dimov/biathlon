package me.biathlonvsu.biathlon.Repository;

import me.biathlonvsu.biathlon.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}