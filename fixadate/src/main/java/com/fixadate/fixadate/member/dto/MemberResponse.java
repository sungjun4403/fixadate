package com.fixadate.fixadate.member.dto;

import com.fixadate.fixadate.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {
    private final Long id;
    private final String refreshToken;
    private final String oauthPlatform;
    private final String oauthId;
    private final String name;
    private final String profileImg;
    private final String nickname;
    private final Integer birth;
    private final Boolean gender; //boolean to selection
    private final String profession;
    private final String signatureColor;

    public MemberResponse(Member member) {
        this.id = member.getId();
        this.refreshToken = member.getRefreshToken();
        this.oauthId = member.getOauthId();
        this.oauthPlatform = member.getOauthPlatform();
        this.profileImg = member.getProfileImg();
        this.name = member.getName();
        this.nickname = member.getNickname();
        this.birth = member.getBirth();
        this.gender = member.getGender();
        this.profession = member.getProfession();
        this.signatureColor = member.getSignatureColor();
    }
    @Builder
    public MemberResponse(Long id, String refreshToken, String name, String oauthPlatform, String profileImg, String oauthId, String nickname, Integer birth, Boolean gender, String profession, String signatureColor) {
        this.id = id;
        this.refreshToken = refreshToken;
        this.oauthPlatform = oauthPlatform;
        this.oauthId = oauthId;
        this.name = name;
        this.profileImg = profileImg;
        this.nickname = nickname;
        this.birth = birth;
        this.gender = gender;
        this.profession = profession;
        this.signatureColor = signatureColor;
    }
}
