package com.thinandlong.hatesugar.member.domain

import com.thinandlong.hatesugar.common.domain.BaseEntity
import com.thinandlong.hatesugar.member.domain.vo.Gender
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class MemberMetadata(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,

    val memberId: Long,

    @Enumerated(EnumType.STRING)
    val gender: Gender,

    val age: Int,

    val height: Float,

    val weight: Float
) : BaseEntity()
