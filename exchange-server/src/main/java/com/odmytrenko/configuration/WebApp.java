package com.odmytrenko.configuration;

import com.odmytrenko.job.UpdateFinanceProviderJob;
import com.odmytrenko.job.UpdateKursProviderJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.odmytrenko.dao")
@EntityScan("com.odmytrenko.model")
@ComponentScan("com.odmytrenko.*")
@EnableConfigurationProperties(ProvidersProperties.class)
public class WebApp {

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }

    @Bean
    @SuppressWarnings("unchecked")
    public FilterRegistrationBean simpleCorsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

    @Bean
    public JobDetail updateKursProviderJobDetail() {
        return JobBuilder.newJob(UpdateKursProviderJob.class).withIdentity("updateKursProviderJob").storeDurably(true).build();
    }

    @Bean
    public Trigger updateKursProviderJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.repeatHourlyForever(5);

        return TriggerBuilder.newTrigger().forJob(updateKursProviderJobDetail())
            .withIdentity("updateKursProviderTrigger").withSchedule(scheduleBuilder).build();
    }

    @Bean
    public JobDetail updateFinanceProviderJobDetail() {
        return JobBuilder.newJob(UpdateFinanceProviderJob.class).withIdentity("updateFinanceProviderJob").storeDurably(true).build();
    }

    @Bean
    public Trigger updateFinanceProviderJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.repeatHourlyForever(3);

        return TriggerBuilder.newTrigger().forJob(updateFinanceProviderJobDetail())
                .withIdentity("updateFinanceProviderTrigger").withSchedule(scheduleBuilder).build();
    }
}
