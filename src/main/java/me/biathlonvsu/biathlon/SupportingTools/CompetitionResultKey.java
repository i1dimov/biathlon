package me.biathlonvsu.biathlon.SupportingTools;



import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class CompetitionResultKey implements Serializable {

    @Column(name = "biathleteId", table = "COMPETITION_RESULT")
    int biathleteId;

    @Column(name = "competitionId", table = "COMPETITION_RESULT")
    int competitionId;

}