package me.biathlonvsu.biathlon.Entity;



import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Table("USER")
@Entity
public class User {

    @Id
    @Column(value = "ID")
    private int id;

    @Column(value = "LOGIN")
    private String login;

    @Column(value = "PASSWORD")
    private int password;

    @Column(value = "NAME")
    private String name;

    @ManyToMany
    @JoinTable(name = "BIATHLETE_SUBSCRIPTION", joinColumns = @JoinColumn(name = "userId"),
              inverseJoinColumns = @JoinColumn(name = "biathleteId"))
    private Set<Biathlete> biathletes;

    //@MappedCollection(idColumn = "ID")
    //@ManyToMany(mappedBy = "ID", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ManyToMany
    @JoinTable(name = "COMPETITION_SUBSCRIPTION", joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "competitionId"))
    private Set<Competition> competitions;
}
