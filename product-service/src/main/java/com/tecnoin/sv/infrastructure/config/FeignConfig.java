package com.tecnoin.sv.infrastructure.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.tecnoin.sv.infrastructure.web.client")
public class FeignConfig {
}