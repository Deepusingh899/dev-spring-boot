package com.learn2code.AOPDemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is the place where we add all our advice

    //declaring the point cut expression
    @Pointcut("execution(* com.learn2code.AOPDemo.dao.*.*(..))")
    public void pointCut(){}
    @Before("pointCut()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======> Executing @Before Advice on addAccount()");
    }
    @Before("pointCut()")
    public void performAPIAnalytics(){
        System.out.println("\n======> Performing API Analytics");
    }
}
