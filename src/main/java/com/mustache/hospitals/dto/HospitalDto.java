package com.mustache.hospitals.dto;

import com.mustache.hospitals.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HospitalDto {
    private Integer id;
    //private String hospitalName;

    public Hospital toEntity() {
        return new Hospital(this.id);
    }
}
