package com.springboot.hospitalboard.domain;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Visit extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String disease;

    private float amount;

    public Visit(String disease, float amount){

        this.disease = disease;
        this.amount = amount;
    }

//    public VisitResponse toResponse() {
//        return VisitResponse.builder()
//                .hospitalName(this.hospital.getHospitalName())
//                .userName(this.user.getUserName())
//                .disease(this.disease)
//                .amount(this.amount)
//                .build();
//    }


}
