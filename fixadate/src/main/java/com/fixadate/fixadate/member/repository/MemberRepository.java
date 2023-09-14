package com.fixadate.fixadate.member.repository;

import com.fixadate.fixadate.member.entity.Member;
import com.fixadate.fixadate.memberTeam.entity.MemberTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByOauthId(String OauthId);
}
