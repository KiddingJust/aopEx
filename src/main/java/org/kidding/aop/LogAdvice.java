package org.kidding.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;



@Aspect
@Log4j
@Order(value= Ordered.HIGHEST_PRECEDENCE)
public class LogAdvice {
	
	@Before("execution(* org.kidding.service.SampleService*.*(String, String)) && args(str1, str2)")
	public void logBefore(String str1, String str2) {
		log.info("-------------------------------------" + str1);
		log.info("-------------------------------------" + str2);

	}
	
	@After("execution(* org.kidding.service.SampleService*.*(..))")
	public void logAfter() {
		log.info("------이거슨 애프터다----------------------");
		log.info("------이거슨 애프터다----------------------");
		log.info("------이거슨 애프터다----------------------");
		log.info("------이거슨 애프터다----------------------");
		log.info("------이거슨 애프터다----------------------");
		log.info("------이거슨 애프터다----------------------");
	}
	
	@AfterReturning("execution(* org.kidding.service.SampleService*.*(..))")
	public void logAfterReturning() {
		log.info("------이거슨 애프터 리터닝이다아---------------------");
		log.info("------이거슨 애프터 리터닝이다아---------------------");
		log.info("------이거슨 애프터 리터닝이다아---------------------");
		log.info("------이거슨 애프터 리터닝이다아---------------------");
		log.info("------이거슨 애프터 리터닝이다아---------------------");

	}
}
