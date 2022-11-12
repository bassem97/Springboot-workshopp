package com.gdsc.springbootworkshop.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Classroom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClassroom;

    @Column(unique = true)
    private String name;

    @OneToMany()
    @JoinColumn(name = "idClassroom")
    List<Student> students;

}
