package me.biathlonvsu.biathlon.Service;

import me.biathlonvsu.biathlon.Entity.Biathlete;
import me.biathlonvsu.biathlon.Repository.BiathleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class BiathleteService {

    @Autowired
    private BiathleteRepository biathleteRepository;

    public Set<Biathlete> getAllBiathletes(){
        return biathleteRepository.findAll();
    }

    public Biathlete getBiathleteById(int id){
        Optional<Biathlete> biathlete = biathleteRepository.findById(id);
        return biathlete.orElse(null);
    }

}
