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

    @Column(name = "BIATHLETE_ID")
    int biathleteId;

    @Column(name = "COMPETITION_ID")
    int competitionId;

}