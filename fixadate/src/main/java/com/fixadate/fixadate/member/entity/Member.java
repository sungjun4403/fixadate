package com.fixadate.fixadate.member.entity;

import com.fixadate.fixadate.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Transactional
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private Long id;

    private String name;
    private Integer birthY;
    private Boolean gender; //boolean to selection
    private String profession;
    private String signatureColor;


//    private String title;
//    private String notes;
//    private String location;
//    private Boolean ifAllDay;
//    private String calColor;
//    private Boolean ifMovable;
//
//    //private to
//    //startsWhen
//    //endsWhen
//    //alertWhen
//    //repeatFreq
//    //guest // contact

}
