package com.test.task.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringConfig.
 *
 * @author Viktoryia Zhak
 */
@Configuration
@ComponentScan("com.test.task")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {
}