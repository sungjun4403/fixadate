package com.fixadate.fixadate.team.dto;

import com.fixadate.fixadate.member.entity.Member;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class TeamCreate {
    private String name;
    private String groupColor;
    private String description;
//    private Set<Member> members = new HashSet<>();
}
