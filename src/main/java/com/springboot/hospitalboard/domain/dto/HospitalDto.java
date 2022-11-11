package com.springboot.hospitalboard.domain.dto;

import com.springboot.hospitalboard.domain.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HospitalDto {

    private int id;
    private String managementNumber;
    private int businessStatus; // 변경가능
    private String phone;
    private String roadNameAddress;
    private String hospitalName;
    private String businessTypeName;
    private int healthcareProviderCount;  // 변경가능
    private int patientRoomCount;  // 변경가능
    private int totalNumberOfBeds;  // 변경가능
    private float totalAreaSize;  // 변경가능

    public HospitalDto(int businessStatus, int healthcareProviderCount, int patientRoomCount, int totalNumberOfBeds) {
        this.businessStatus = businessStatus;
        this.healthcareProviderCount = healthcareProviderCount;
        this.patientRoomCount = patientRoomCount;
        this.totalNumberOfBeds = totalNumberOfBeds;
    }

    public Hospital toEntity(){
        return new Hospital(id, roadNameAddress, hospitalName, businessTypeName, healthcareProviderCount, patientRoomCount, totalNumberOfBeds);
    }



}
