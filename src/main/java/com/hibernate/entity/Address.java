package com.hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_address")
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @Column(length = 50, name = "STREET")
    private String street;

    @Column(length = 100, name = "CITY")
    private String city;

    @Column(name = "is_open")
    private boolean isOpen;

    @Transient
    private double x;

    @Column(name = "added_date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Lob
    private byte[] image;

}
