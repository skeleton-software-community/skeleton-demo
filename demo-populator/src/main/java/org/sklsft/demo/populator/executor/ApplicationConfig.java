package org.sklsft.demo.populator.executor;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "org.sklsft.demo, org.sklsft.generator")
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

}