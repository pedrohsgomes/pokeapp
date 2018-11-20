package br.com.pokeapimanager.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "br.com.pokeapimanager.app.service" })
public class ServiceConfig {
}
