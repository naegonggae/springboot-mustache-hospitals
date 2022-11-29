package com.mustache.hospitals.dto;

import com.mustache.hospitals.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class HospitalDto {
    private Integer id;
    private String hospitalName;
    private String roadNameAddress;
    private String businessTypeName;

    public Hospital toEntity() {
        return new Hospital(this.id, this.hospitalName, this.roadNameAddress, this.businessTypeName);
    }
}
