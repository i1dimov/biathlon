package me.biathlonvsu.biathlon.Entity;



import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import me.biathlonvsu.biathlon.SupportingTools.Gender;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @Column(value = "ID")
    private int id;

    @Column(value = "NAME")
    private String name;

    @Column(value = "secondName")
    private String secondName;

    @Column(value = "birthDate")
    private Date birthDate;

    @Column(value = "GENDER")
    private Gender gender;

    @OneToMany(mappedBy = "biathlete")
    Set<CompetitionResult> competitionResults;

    private int scoreInLastSeason;

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


