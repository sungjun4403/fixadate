package com.fixadate.fixadate.team.entity;


import com.fixadate.fixadate.global.entity.BaseTimeEntity;
import com.fixadate.fixadate.member.entity.Member;
import com.fixadate.fixadate.memberTeam.entity.MemberTeam;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    List<MemberTeam> memberTeamList = new ArrayList<>();

}
