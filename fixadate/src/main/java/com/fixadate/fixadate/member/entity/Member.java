package com.fixadate.fixadate.member.entity;

import com.fixadate.fixadate.global.entity.BaseTimeEntity;
import com.fixadate.fixadate.group.entity.Team;
import com.fixadate.fixadate.member.dto.MemberEditor;
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
