package com.thinandlong.hatesugar.common.presentation

import com.thinandlong.hatesugar.common.dto.HealthResponse
import com.thinandlong.hatesugar.common.dto.ok
import com.thinandlong.hatesugar.config.web.APPLICATION_JSON_UTF8_VALUE
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/", "health"], produces = [APPLICATION_JSON_UTF8_VALUE])
class HealthController(
    private val environment: Environment
) {
    @GetMapping
    fun healthCheck() = HealthResponse(
        profiles = environment.activeProfiles.toList()
    ).ok()
}
