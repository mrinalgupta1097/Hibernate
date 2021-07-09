package com.hibernate.OneToManyExercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServicesCards {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cardNo;
    private String company;
    private String service;

    @ManyToOne
    private Employee employee;
}
