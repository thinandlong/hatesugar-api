package com.thinandlong.hatesugar.config.client

import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.web.client.RestTemplate
import java.nio.charset.StandardCharsets


@Configuration
class RestTemplateConfig {
    private val maxTotalConnect: Int = 0
    private val maxConnectPerRoute: Int = 100
    private val connectTimeout: Int = 3000
    private val readTimeout: Int = 5000

    @Bean
    fun restTemplate(): RestTemplate {
        val restTemplate = RestTemplate(this.createFactory())

        val converterList = restTemplate.messageConverters

        val converterTarget = converterList.firstOrNull {
            StringHttpMessageConverter::class.java == it.javaClass
        }

        if (null != converterTarget) {
            converterList.remove(converterTarget)
        }

        converterList.add(1, StringHttpMessageConverter(StandardCharsets.UTF_8))

        return restTemplate
    }

    private fun createFactory(): ClientHttpRequestFactory {
        if (maxTotalConnect <= 0) {
            return simpleClientHttpRequestFactory()
        }
        return httpComponentsClientHttpRequestFactory()
    }

    private fun simpleClientHttpRequestFactory(): SimpleClientHttpRequestFactory {
        return SimpleClientHttpRequestFactory()
            .apply {
                this.setReadTimeout(readTimeout)
                this.setConnectTimeout(connectTimeout)
            }
    }

    private fun httpComponentsClientHttpRequestFactory(): HttpComponentsClientHttpRequestFactory {
        return HttpComponentsClientHttpRequestFactory(closeableHttpClient())
            .apply {
                this.setConnectTimeout(connectTimeout)
                this.setReadTimeout(readTimeout)
            }
    }

    private fun closeableHttpClient(): CloseableHttpClient {
        return HttpClientBuilder.create()
            .setMaxConnTotal(maxTotalConnect)
            .setMaxConnPerRoute(maxConnectPerRoute)
            .build()
    }
}
