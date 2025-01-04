package com.learn2code.AOPDemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is the place where we add all our advice
    @Before("execution(public void com.learn2code.AOPDemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n======> Executing @Before Advice on addAccount()");
    }
}
