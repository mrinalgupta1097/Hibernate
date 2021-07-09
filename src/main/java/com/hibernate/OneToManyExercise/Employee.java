package com.hibernate.OneToManyExercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int employeeId;
    private String name;
    private String city;
    private String emailId;
    private String phoneNo;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<ServicesCards> servicesCards;
}
