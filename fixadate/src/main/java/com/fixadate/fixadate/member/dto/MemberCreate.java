package com.fixadate.fixadate.member.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class MemberCreate {
    private String name;
    private String refreshToken;
    private String oauthId;
    private String oauthPlatform;
    private String profileImg;
    private String nickname;
    private Integer birth;
    private Boolean gender;
    private String profession;
    private String signatureColor;

    @Builder
    public MemberCreate(String name, String refreshToken, String oauthId, String oauthPlatform, String profileImg, String nickname, Integer birth, Boolean gender, String profession, String signatureColor) {
        this.name = name;
        this.refreshToken = refreshToken;
        this.oauthId = oauthId;
        this.oauthPlatform = oauthPlatform;
        this.profileImg = profileImg;
        this.nickname = nickname;
        this.birth = birth;
        this.gender = gender;
        this.profession = profession;
        this.signatureColor = signatureColor;
    }
}
