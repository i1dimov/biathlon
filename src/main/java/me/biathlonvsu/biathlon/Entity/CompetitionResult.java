package me.biathlonvsu.biathlon.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.biathlonvsu.biathlon.SupportingTools.CompetitionResultKey;


import javax.persistence.*;


@Data
@EqualsAndHashCode(exclude = {"biathlete", "competition"})
@NoArgsConstructor
@Entity
public class CompetitionResult {

    @EmbeddedId
    CompetitionResultKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("biathleteId")
    @JoinColumn(name = "BIATHLETE_ID")
    @JsonIgnore
    Biathlete biathlete;

    @ManyToOne()
    @MapsId("competitionId")
    @JoinColumn(name = "COMPETITION_ID")
    @JsonIgnore
    Competition competition;

    @Transient
    String biathleteName;

    @Transient
    String competitionName;

    int score;

    public String getBiathleteName() {
        biathleteName = biathlete.getName() + " " + biathlete.getSecondName();
        return biathleteName;
    }

    public String getCompetitionName() {
        competitionName = competition.getName();
        return competitionName;
    }
}
