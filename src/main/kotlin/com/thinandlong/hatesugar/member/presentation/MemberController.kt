package com.thinandlong.hatesugar.member.presentation

import com.thinandlong.hatesugar.config.web.APPLICATION_JSON_UTF8_VALUE
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api("1. 사용자 API")
@RestController
@RequestMapping("/api/v1/member", produces = [APPLICATION_JSON_UTF8_VALUE])
class MemberController {

}
