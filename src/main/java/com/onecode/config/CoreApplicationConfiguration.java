package com.onecode.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author One_Code
 * This for load classpath configuration file.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan({ "com.onecode.model" }) // entityscan and component scan we can exclude also because main annoation will
											// do this by default
@ComponentScan({ "com.onecode.config", "com.onecode.service", "com.onecode.repository",
		"com.onecode.controller", "com.onecode.model", "com.onecode", "com.onecode.utils" })
@PropertySources({ @PropertySource("classpath:messages.properties"), @PropertySource("classpath:log4j.properties") })
@EnableTransactionManagement
@EnableAsync
public class CoreApplicationConfiguration {

}