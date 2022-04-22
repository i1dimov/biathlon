package me.biathlonvsu.biathlon.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import me.biathlonvsu.biathlon.SupportingTools.Gender;
import me.biathlonvsu.biathlon.SupportingTools.Nationality;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;


@Data
@EqualsAndHashCode
@NoArgsConstructor
@Table("BIATHLETE")
@Entity
public class Biathlete {

    @Id
    @Column(name = "BIATHLETE_ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SECOND_NAME")
    private String secondName;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "NATIONALITY")
    @Enumerated(EnumType.STRING)
    private Nationality nationality;

    @OneToMany(mappedBy = "biathlete")
    Set<CompetitionResult> competitionResults;

    @Transient
    int scoreInLastSeason;

    public void recalculationScore(){
        scoreInLastSeason = 0;
        Date dateNow = new Date();
        Date startSeason, finishSeason;
        if (dateNow.getMonth() > Calendar.AUGUST){
            startSeason = new Date(dateNow.getYear(), Calendar.SEPTEMBER, 1);
            finishSeason = new Date(dateNow.getYear()+1, Calendar.JUNE, 1);
        }
        else {
            startSeason = new Date(dateNow.getYear()-1, Calendar.SEPTEMBER, 1);
            finishSeason = new Date(dateNow.getYear(), Calendar.JUNE, 1);
        }
        competitionResults.forEach(competitionResult -> {
            if (competitionResult.competition.getDate().after(startSeason)
                    && competitionResult.competition.getDate().before(finishSeason)){
                scoreInLastSeason = scoreInLastSeason + competitionResult.getScore();
            }
        });
    }

    public int getScoreInLastSeason(){
        recalculationScore();
        return scoreInLastSeason;
    }
}


