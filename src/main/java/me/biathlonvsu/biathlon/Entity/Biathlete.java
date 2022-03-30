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

}


