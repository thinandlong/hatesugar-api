package com.thinandlong.hatesugar.member.infrastructure

import com.thinandlong.hatesugar.member.domain.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long>
