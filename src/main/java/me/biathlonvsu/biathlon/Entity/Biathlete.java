package me.biathlonvsu.biathlon.Entity;



import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;


@Data
@EqualsAndHashCode
@NoArgsConstructor
@Table("BIATHLETE")
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

}

enum Gender {
    MAN,
    WOMAN
}


