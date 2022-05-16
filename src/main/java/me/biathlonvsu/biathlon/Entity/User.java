package me.biathlonvsu.biathlon.Entity;



import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private int password;

    @Column(name = "NAME")
    private String name;

    @ManyToMany
    @JoinTable(name = "BIATHLETE_SUBSCRIPTION", joinColumns = @JoinColumn(name = "USER_ID"),
              inverseJoinColumns = @JoinColumn(name = "BIATHLETE_ID"))
    private Set<Biathlete> biathletes;

    @ManyToMany
    @JoinTable(name = "COMPETITION_SUBSCRIPTION", joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "COMPETITION_ID"))
    private Set<Competition> competitions;
}
