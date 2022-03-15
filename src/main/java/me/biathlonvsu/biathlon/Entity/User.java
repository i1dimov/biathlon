package me.biathlonvsu.biathlon.Entity;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Table("USER")
public class User {

    @Id
    @Column(value = "ID")
    private int id;

    @Column(value = "LOGIN")
    private String login;

    @Column(value = "PASSWORD")
    private String password;

    @Column(value = "NAME")
    private String name;

    @MappedCollection(idColumn = "ID")
    private Set<Biathlete> biathletes;

    @MappedCollection(idColumn = "ID")
    private Set<Competition> competitions;
}
