package me.biathlonvsu.biathlon.Entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import javax.persistence.*;

import java.util.Date;
import java.util.Set;


@Data
@EqualsAndHashCode
@NoArgsConstructor
@Table("COMPETITION")
@Entity
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

    @OneToMany(mappedBy = "competition")
    Set<CompetitionResult> competitionResults;

}
