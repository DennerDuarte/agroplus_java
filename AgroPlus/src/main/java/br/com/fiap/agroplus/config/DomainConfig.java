package br.com.fiap.agroplus.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("br.com.fiap.agroplus.entity")
@EnableJpaRepositories("br.com.fiap.agroplus.repository")
@EnableTransactionManagement
public class DomainConfig {
}
