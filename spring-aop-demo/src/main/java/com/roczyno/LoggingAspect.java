package com.roczyno;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;

@Aspect
@ComponentScan
public class LoggingAspect {
	@Before("execution(* com.roczyno.ShoppingCart.checkout())")
	public void logger(){
		System.out.println("Loggers");
	}
}
