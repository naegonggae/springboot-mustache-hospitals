package com.mustache.hospitals.service;

import com.mustache.hospitals.dto.HospitalResponse;
import com.mustache.hospitals.entity.Hospital;
import com.mustache.hospitals.repository.HospitalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
// Business영역
// controller의 로직은 서비스에서 구현해줘야함
@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponse getHospital(Integer id) {
        Optional<Hospital> optHospital = hospitalRepository.findById(id); //Entity
        Hospital hospital = optHospital.get();
        HospitalResponse hospitalResponse = Hospital.of(hospital); // DTO

        /*
        switch (hospital.getBusinessStatusCode()) {
            case 13: hospitalResponse.setBusinessStatusName("영업중"); break;
            case 3: hospitalResponse.setBusinessStatusName("폐업"); break;
            case 4: hospitalResponse.setBusinessStatusName(); break;
            case 24: hospitalResponse.setBusinessStatusName(); break;
        }
        */
        if (hospital.getBusinessStatusCode() == 13) {
            hospitalResponse.setBusinessStatusName("영업중");
        } else if (hospital.getBusinessStatusCode() == 3) {
            hospitalResponse.setBusinessStatusName("폐업");
        } else {
            hospitalResponse.setBusinessStatusName(String.valueOf(hospital.getBusinessStatusCode()));
        }
        return hospitalResponse;
    }
}
