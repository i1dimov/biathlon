package me.biathlonvsu.biathlon.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import me.biathlonvsu.biathlon.SupportingTools.CompetitionResultKey;


import javax.persistence.*;


@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class CompetitionResult {

    @EmbeddedId
    CompetitionResultKey id;

    @ManyToOne
    @MapsId("biathleteId")
    @JoinColumn(name = "biathleteId", table = "COMPETITION_RESULT")
    Biathlete biathlete;

    @ManyToOne
    @MapsId("competitionId")
    @JoinColumn(name = "competitionId", table = "COMPETITION_RESULT")
    Competition competition;

    int score;

}
