package org.kidding.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;


@Aspect
@Log4j
@Order(value= Ordered.HIGHEST_PRECEDENCE)
public class NullAdvice {

	
	// 리플렉션. 이를 통해 많은 정보를 파악할 수 있음.
	@Around("execution(* org.kidding.service.SampleService*.*(..))")
	public Object checkNull(ProceedingJoinPoint pjp) {
		log.info("check Null.............................");
		log.info("check Null.............................");
		log.info("check Null.............................");
		
		Object result = null;
		try {
			//메소드의 실행 자체를 막는 것. 
			boolean checkNull = false;
			Object[] params = pjp.getArgs();
			
			for (Object object : params) {
				if(object == null) {
					throw new Exception("");
				}
			}
			
			result = pjp.proceed();		//메세지를 실행하는 역할. invoke. 메서드 invoke 하기 전에 NULL 체크를 해주면 되지. 
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
}
