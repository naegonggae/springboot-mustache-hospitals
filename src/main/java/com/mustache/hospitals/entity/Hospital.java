package com.mustache.hospitals.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name="nation_wide_hospitals")
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @Id
    private Integer id;
    @Column(name = "hospital_name")
    private String hospitalName;
    private String roadNameAddress;
}
