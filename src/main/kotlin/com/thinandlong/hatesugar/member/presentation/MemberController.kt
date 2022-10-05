package com.thinandlong.hatesugar.member.presentation

import com.thinandlong.hatesugar.config.web.APPLICATION_JSON_UTF8_VALUE
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/member", produces = [APPLICATION_JSON_UTF8_VALUE])
class MemberController {
}
