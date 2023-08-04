package com.fixadate.fixadate.group.entity;


import com.fixadate.fixadate.global.entity.BaseTimeEntity;
import com.fixadate.fixadate.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Transactional
public class Team extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teamId")
    private Long id;

    private String name;
    private String groupColor;
    private String description;

}
