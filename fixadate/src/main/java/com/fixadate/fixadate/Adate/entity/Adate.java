package com.fixadate.fixadate.Adate.entity;


import com.fixadate.fixadate.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Transactional
public class Adate extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adateId")
    private Long id;

    private String title;
    private String notes;
    private String location;
    private Boolean ifAllDay;
    private String calColor;
    private Boolean ifMovable;

    //private to
    //startsWhen
    //endsWhen
    //alertWhen
    //repeatFreq
    //guest // contact
}
