package com.wencom.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.wencom")
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {
}
