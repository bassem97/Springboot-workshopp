package com.gdsc.springbootworkshop.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private GENDER gender;

}
