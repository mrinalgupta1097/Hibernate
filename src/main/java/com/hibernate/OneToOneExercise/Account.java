package com.hibernate.OneToOneExercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {
    @Id
    private int accountNo;
    private double balance;
    @Column(nullable = false)
    private String accountType;

    @OneToOne(mappedBy = "account")
    private Customer customer;
}
