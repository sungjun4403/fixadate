package com.fixadate.fixadate.member.repository;

import com.fixadate.fixadate.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
