package com.gdsc.springbootworkshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
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

  @ManyToOne
  @JoinColumn(name = "idClassroom")
  @JsonIgnoreProperties({ "students" })
  Classroom classroom;
}
