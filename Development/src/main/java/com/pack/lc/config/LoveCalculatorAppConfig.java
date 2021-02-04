package com.pack.lc.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.pack.lc.formatter.PhoneNumberFormatter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.pack.lc")
public class LoveCalculatorAppConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	// telefon numarasını formatlamak icin webmvcconfigureri ekledik ve bu methodu override ettik.
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new PhoneNumberFormatter());
	}
	
	
	
	// bu alttaki 3 method sadece properties fileden annotation hata mesaji vermek icin
	@Bean
	MessageSource messageSource() {
		ResourceBundleMessageSource messageSource= new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	@Bean(name = "validator")
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		//validasyon için üstteki methoda bak o üstteki methodda gidip propertiese baksın
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}
	
	@Override
	public Validator getValidator() {
		// TODO Auto-generated method stub
		return validator();
	}
	
}
