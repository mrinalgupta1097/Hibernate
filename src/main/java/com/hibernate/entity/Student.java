package com.hibernate.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.hibernate.entity.Certificate;

@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    private int id;
    private String name;
    private String city;

    public Certificate certificate;


}
