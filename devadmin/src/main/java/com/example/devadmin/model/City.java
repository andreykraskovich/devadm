package com.example.devadmin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class City {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @Column(name = "country_code")
    private String countryCode;

    private String district;

    private String population;
}
