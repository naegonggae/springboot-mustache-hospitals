package com.mustache.hospitals.repository;

import com.mustache.hospitals.entity.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    // findBYBusinessTypeNameIn 사용하기 In 연산자 사용
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
    List<Hospital> findByHospitalNameStartsWith(String keyword); // 시작
    List<Hospital> findByHospitalNameEndsWith(String keyword); // 끝남
    List<Hospital> findByPatientRoomCountGreaterThanAndPatientRoomCountLessThan(int var1, int var2);
    List<Hospital> findByTotalAreaSizeBetween(float a, float b);
    List<Hospital> findByRoadNameAddressContainingOrderByTotalAreaSize(String str);

    //List<Hospital> findByRoadNameAddressContaining(String keyword); // 포함
    Page<Hospital> findByRoadNameAddressContaining(String keyword, Pageable pageable); // 검색기능사용할거야
}
