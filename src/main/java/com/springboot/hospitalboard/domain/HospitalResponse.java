package com.springboot.hospitalboard.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HospitalResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String managementNumber;
    private String phone;
    private String roadNameAddress;
    private String hospitalName;
    private String businessTypeName;
    private int healthcareProviderCount;
    private int patientRoomCount;
    private int totalNumberOfBeds;
    private float totalAreaSize;


    private String businessStatusName;

    public HospitalResponse(int id, String managementNumber, String roadNameAddress, String hospitalName, String businessTypeName,
                            int healthcareProviderCount, int patientRoomCount, int totalNumberOfBeds) {
        this.id = id;
        this.managementNumber = managementNumber;
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
        this.businessTypeName = businessTypeName;
        this.healthcareProviderCount = healthcareProviderCount;
        this.patientRoomCount = patientRoomCount;
        this.totalNumberOfBeds = totalNumberOfBeds;
    }

    public void setBusinessStatusName(String businessStatusName) {
        this.businessStatusName = businessStatusName;
    }



}
