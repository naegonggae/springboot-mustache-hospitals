--전체찾기--
SELECT * FROM `likelion-db`.nation_wide_hospitals limit 100;

--경기도 수원시에 있는 피부과 찾기--
SELECT hospital_name, road_name_address FROM `likelion-db`.nation_wide_hospitals
where road_name_address like "경기도 수원시%"
;

SELECT hospital_name, road_name_address FROM `likelion-db`.nation_wide_hospitals
where road_name_address like "경기도 수원시%"
  and hospital_name like "%피부과%"
;

--business_type_name 보건소, 보건지소인 데이터--
SELECT business_type_name, hospital_name, road_name_address
FROM `likelion-db`.nation_wide_hospitals
where business_type_name in ('보건소', '보건지소')
;

--in, and, like를 모두 사용한 쿼리--
SELECT business_type_name, hospital_name, road_name_address
FROM `likelion-db`.nation_wide_hospitals
where business_type_name in ('보건소', '보건지소')
;

--10 초과--
SELECT hospital_name, patient_room_count FROM `likelion-db`.nation_wide_hospitals
where patient_room_count > 10
order by patient_room_count desc;

--10이상 20미만--
SELECT hospital_name, patient_room_count FROM `likelion-db`.nation_wide_hospitals
where patient_room_count >= 10 and patient_room_count < 20
order by patient_room_count desc;

--10이상 20미만 between--
SELECT hospital_name, patient_room_count FROM `likelion-db`.nation_wide_hospitals
where patient_room_count between 10 and 19
order by patient_room_count desc;

--desc는 내림차순 아무것도 안붙이면 기본값은 오름차순(asc)--
SELECT hospital_name, patient_room_count FROM `likelion-db`.nation_wide_hospitals
where patient_room_count between 10 and 19
order by patient_room_count desc;

--business_status_code 에서 중복제거 후 출력--
SELECT distinct business_status_code FROM `likelion-db`.nation_wide_hospitals;

business_status_code
# business_status_code 전체 조회
select distinct business_status_code from nation_wide_hospitals;

# business_status_code 가 13인 레코드 조회
select * from nation_wide_hospitals
where business_status_code = 13;

# business_status_code 가 3인 레코드 조회
select * from nation_wide_hospitals
where business_status_code = 3;
