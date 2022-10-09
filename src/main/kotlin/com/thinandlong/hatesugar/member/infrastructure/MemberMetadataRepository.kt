package com.thinandlong.hatesugar.member.infrastructure

import com.thinandlong.hatesugar.member.domain.MemberMetadata
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberMetadataRepository : JpaRepository<MemberMetadata, Long>
