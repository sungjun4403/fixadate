package com.fixadate.fixadate.memberTeam.repository;

import com.fixadate.fixadate.memberTeam.entity.MemberTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberTeamRepository extends JpaRepository<MemberTeam, Long> {
    List<MemberTeam> findAllByMemberId(Long memberId);
}
