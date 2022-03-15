package me.biathlonvsu.biathlon.Entity;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import javax.persistence.*;

import java.util.Date;
import java.util.Map;


@Data
@EqualsAndHashCode
@NoArgsConstructor
@Table("COMPETITION")
public class Competition {

    @Id
    @Column(value = "ID")
    private int id;

    @Column(value = "NAME")
    private String name;

    @Column(value = "DATA")
    private Date date;

    @Column(value = "LOCATION")
    private String location;

    @ElementCollection
    @CollectionTable(name = "COMPETITION_RESULT", joinColumns = {@JoinColumn(name = "competitionId")})
    @MapKeyColumn(name = "biathleteId")
    private Map<Biathlete, Integer> result;

}
