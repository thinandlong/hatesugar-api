package com.thinandlong.hatesugar.food.infrastructure

import com.thinandlong.hatesugar.food.domain.FoodMetadata
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FoodMetadataRepository : JpaRepository<FoodMetadata, Long>
