package com.mustache.hospitals.dto;

import com.mustache.hospitals.entity.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDto {
    private Integer id;
    private String hospitalName;
    private String roadNameAddress;
    private String businessTypeName;
    private Float totalAreaSize;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;

    private String businessStatusCode;

    public Hospital toEntity() {
        return Hospital.builder()
                .id(this.id)
                .roadNameAddress(this.roadNameAddress)
                .hospitalName(this.hospitalName)
                .businessTypeName(this.businessTypeName)
                .totalAreaSize(this.totalAreaSize)
                .patientRoomCount(this.patientRoomCount)
                .totalNumberOfBeds(this.totalNumberOfBeds)
                .build();
    }
}
