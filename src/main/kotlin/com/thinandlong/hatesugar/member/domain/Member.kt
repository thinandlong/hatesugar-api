package com.thinandlong.hatesugar.member.domain

import com.thinandlong.hatesugar.common.domain.BaseEntity
import com.thinandlong.hatesugar.member.domain.vo.Gender
import com.thinandlong.hatesugar.member.domain.vo.LoginType
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,

    @Enumerated(EnumType.STRING)
    var loginType: LoginType,

    val username: String,

    val password: String,

    @Enumerated(EnumType.STRING)
    val gender: Gender,

    val age: Int
) : BaseEntity()
