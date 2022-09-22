package com.dd.tiger.test.conf;


import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConf implements WebMvcConfigurer {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:i18n/arena","classpath:i18n/valid");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
        MessageInterpolatorFactory interpolatorFactory = new MessageInterpolatorFactory();
        factoryBean.setMessageInterpolator(interpolatorFactory.getObject());
        // Set to fail fast, the Hibernate validation framework by default validates
        // all rules set by all fields and returns an error collection.
        // Fast failure means that as long as an error occurs during verification,
        // it returns immediately, and the subsequent verification rules are not executed.
        factoryBean.getValidationPropertyMap().put("hibernate.validator.fail_fast", "true");
        // Validator i18n conf
        factoryBean.setValidationMessageSource(messageSource());
        return factoryBean;
    }
}
