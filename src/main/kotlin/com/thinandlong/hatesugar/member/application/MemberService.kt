package com.thinandlong.hatesugar.member.application

import com.thinandlong.hatesugar.member.infrastructure.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val memwberRepository: MemberRepository
) {
}
