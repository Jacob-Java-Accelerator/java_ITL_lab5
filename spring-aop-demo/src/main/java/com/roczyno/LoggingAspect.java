package com.roczyno;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution(* com.roczyno.ShoppingCart.checkout())")
	public void logger(){
		System.out.println("Loggers");
	}
}
