package io.github.Guimaj.VendasApplication.Configuration;

import org.apache.tomcat.jni.Local;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class InternacionalizationConfig {

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource message = new ReloadableResourceBundleMessageSource();
        // arquivo contendo as mensagens
        message.setBasename("classpath:messages");
        message.setDefaultEncoding("ISO-8859-1");
        message.setDefaultLocale(Locale.getDefault());
        return message;
    }

    /* integracao entre as mensagens e a validacao */
    @Bean
    public LocalValidatorFactoryBean validator(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
