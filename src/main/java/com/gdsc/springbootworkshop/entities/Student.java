package com.gdsc.springbootworkshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

//    Getters and Setters

}
