package com.thinandlong.hatesugar.food.domain

import com.thinandlong.hatesugar.common.domain.BaseEntity
import org.hibernate.annotations.Comment
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Food(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,

    val name: String,

    val totalCalories: Double = 0.0,

    @Comment("탄수화물")
    val carbohydrate: Float = 0f,

    @Comment("단백질")
    val protein: Float = 0f,

    @Comment("지방")
    val fat: Float = 0f,

    @Comment("당류")
    val sugars: Float = 0f,

    @Comment("나트륨")
    val natrium: Float = 0f,

    @Comment("콜레스트레롤")
    val cholesterol: Float = 0f,

    @Comment("포화지방산")
    val saturatedFatty: Float = 0f,

    @Comment("트랜스지방산")
    val transFatty: Float = 0f
) : BaseEntity()
