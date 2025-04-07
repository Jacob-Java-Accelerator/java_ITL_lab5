package com.roczyno;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.roczyno")
@EnableAspectJAutoProxy
public class BeanConfig {
}
