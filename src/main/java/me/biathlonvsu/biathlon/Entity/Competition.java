package me.biathlonvsu.biathlon.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    @Column(name = "COMPETITION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "LOCATION")
    private String location;

    @OneToMany(mappedBy = "competition")
    //@JsonBackReference
    Set<CompetitionResult> competitionResults;
}
