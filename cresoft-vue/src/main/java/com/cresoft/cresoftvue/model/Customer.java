package com.cresoft.cresoftvue.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(length = 45, nullable = false)
    private String id;
    @Column(length = 30, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String country;
    @Column(length = 20, nullable = false)
    private String city;
    @Column(length = 5, nullable = false)
    private String currency;
    @Column(length = 20, nullable = false)
    private String contact;
}
