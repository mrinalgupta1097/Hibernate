package com.hibernate.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    private int id;
    private String name;
    private String city;


}
