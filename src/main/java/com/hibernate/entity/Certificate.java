package com.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable
public class Certificate {

    /*
    @Embeddable specifies a class whose properties should be embedded as properties in other class.
    Simply put when we dont want to create another table and use mapping
     but still want to use the rows of another table in the owning table we use @Embeddable.
     */

    public String course;
    public String duration;
}
