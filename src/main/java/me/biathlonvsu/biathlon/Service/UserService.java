package me.biathlonvsu.biathlon.Service;




import me.biathlonvsu.biathlon.Entity.Competition;
import me.biathlonvsu.biathlon.Entity.User;
import me.biathlonvsu.biathlon.Repository.BiathleteRepository;
import me.biathlonvsu.biathlon.Repository.CompetitionRepository;
import me.biathlonvsu.biathlon.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BiathleteRepository biathleteRepository;

    @Autowired
    private CompetitionRepository competitionRepository;

    public boolean subscribeToBiathlete(int userId, int biathleteId){
        boolean b = userRepository.findById(userId).isPresent() && biathleteRepository.findById(biathleteId).isPresent();
        if (b){
            boolean r = userRepository.findById(userId).get().getBiathletes().
                    add(biathleteRepository.findById(biathleteId).get());
            userRepository.save(userRepository.findById(userId).get());
            return r;
        } else return false;
    }

    public boolean subscribeToCompetition(int userId, int competitionId){
        boolean b = userRepository.findById(userId).isPresent() && competitionRepository.findById(competitionId).isPresent();
        if (b){
            boolean r = userRepository.findById(userId).get().getCompetitions().
                    add(competitionRepository.findById(competitionId).get());
            userRepository.save(userRepository.findById(userId).get());
            return r;
        } else return false;
    }

    public boolean unsubscribeFromBiathlete(int userId, int biathleteId){
        boolean b = userRepository.findById(userId).isPresent() && biathleteRepository.findById(biathleteId).isPresent();
        if (b){
            boolean r = userRepository.findById(userId).get().getBiathletes().
                    remove(biathleteRepository.findById(biathleteId).get());
            userRepository.save(userRepository.findById(userId).get());
            return r;
        } else return false;
    }

    public boolean unsubscribeFromCompetition(int userId, int competitionId){
        boolean b = userRepository.findById(userId).isPresent() && competitionRepository.findById(competitionId).isPresent();
        if (b){
            boolean r = userRepository.findById(userId).get().getCompetitions().
                    remove(competitionRepository.findById(competitionId).get());
            userRepository.save(userRepository.findById(userId).get());
            return r;
        } else return false;
    }

    public Set<Competition> getAllSubscribeCompetitions(int userId){
        boolean b = userRepository.findById(userId).isPresent();
        if (b) return userRepository.findById(userId).get().getCompetitions();
        else return null;
    }

    public Set<Competition> getAllCompetitionsSubscribeWithBiathletes(int userId){
        Set<Competition> competitions = new HashSet<>();
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) return null;
        user.get().getBiathletes().forEach(biathlete -> biathlete.getCompetitionResults().
                forEach(competitionResult -> competitions.add(competitionResult.getCompetition())));
        return competitions;
    }//мы берем у каждого биатлониста(на которого подписан юзер) его участие в соревновании отдаем сет с этими соревнованиями

    public User register(String login, int password, String name){
        if (userRepository.findByLogin(login).isPresent()) return null;
        User user = new User();
        user.setLogin(login);
        user.setName(name);
        user.setPassword(password);
        userRepository.save(user);
        return user;
    }

    public User logIn(String login, int password){
        Optional<User> user = userRepository.findByLogin(login);
        if (user.isPresent()) {
            if (user.get().getPassword() == password) return user.get();
        }
        return null;
    }

    public boolean changePassword(int userId, int password){
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            user.get().setPassword(password);
            userRepository.save(userRepository.findById(userId).get());
            return true;
        }
        return false;
    }
}

