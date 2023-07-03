package com.example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder
import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerReactiveAuthenticationManagerResolver
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
open class SpringWebfluxSecurityConfiguration{
    @Bean
    open fun springSecurityFilterChain(
        http: ServerHttpSecurity,
        jwtDecoder: ReactiveJwtDecoder
    ): SecurityWebFilterChain {
        return http
            .authorizeExchange { exchange ->
                exchange
                    .pathMatchers("/public-**").permitAll()
                    .anyExchange().authenticated()
            }
            .oauth2ResourceServer { server ->
                server.jwt { it.jwtDecoder(jwtDecoder) }

            }.build()
    }
}
