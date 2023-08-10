package com.fixadate.fixadate.member.entity;

import com.fixadate.fixadate.global.entity.BaseTimeEntity;
import com.fixadate.fixadate.member.dto.MemberEditor;
import com.fixadate.fixadate.memberTeam.entity.MemberTeam;
import com.fixadate.fixadate.team.entity.Team;
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
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private Long id;

    private String name;
    private String nickname;
    private Integer birth;
    private Boolean gender; //boolean to selection
    private String profession;
    private String signatureColor;


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    List<MemberTeam> memberTeamList = new ArrayList<>();



    public MemberEditor.MemberEditorBuilder toEditor() {
        return MemberEditor.builder()
                .name(name)
                .nickname(nickname)
                .birth(birth)
                .gender(gender)
                .profession(profession)
                .signatureColor(signatureColor);
    }


    public void edit(MemberEditor memberEditor) {
        name = memberEditor.getName();
        nickname = memberEditor.getNickname();
        birth = memberEditor.getBirth();
        gender = memberEditor.getGender();
        profession = memberEditor.getProfession();
        signatureColor = memberEditor.getSignatureColor();

    }

}
