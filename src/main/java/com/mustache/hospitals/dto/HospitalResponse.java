package com.mustache.hospitals.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 얘는 dto야
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class HospitalResponse {
    private Integer id;
    private String roadNameAddress;
    private String hospitalName;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private String businessTypeName;
    private Float totalAreaSize;

    // businessStatusName뺘고 생성자 하나 만들어줘
    public HospitalResponse(Integer id, String roadNameAddress, String hospitalName, Integer patientRoomCount,
                            Integer totalNumberOfBeds, String businessTypeName, Float totalAreaSize) {
        this.id = id;
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
        this.patientRoomCount = patientRoomCount;
        this.totalNumberOfBeds = totalNumberOfBeds;
        this.businessTypeName = businessTypeName;
        this.totalAreaSize = totalAreaSize;
    }

    private String businessStatusName; // 이거 새로 추가

    public void setBusinessStatusName(String businessStatusName) { // setter 만들어주기
        this.businessStatusName = businessStatusName;
    }
}


