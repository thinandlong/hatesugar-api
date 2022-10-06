package com.thinandlong.hatesugar.food.infrastructure

import com.thinandlong.hatesugar.food.domain.Food
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FoodRepository : JpaRepository<Food, Long>
