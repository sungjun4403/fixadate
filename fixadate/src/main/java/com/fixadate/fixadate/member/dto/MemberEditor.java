package com.fixadate.fixadate.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberEditor {
    private String name;
    private String nickname;
    private Integer birth;
    private Boolean gender;
    private String profession;
    private String signatureColor;

    @Builder
    public MemberEditor(String name, String nickname, Integer birth, Boolean gender, String profession, String signatureColor) {
        this.name = name;
        this.nickname = nickname;
        this.birth = birth;
        this.gender = gender;
        this.profession = profession;
        this.signatureColor = signatureColor;
    }

}
