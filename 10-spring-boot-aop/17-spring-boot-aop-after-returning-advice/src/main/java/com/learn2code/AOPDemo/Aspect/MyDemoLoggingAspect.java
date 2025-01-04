package com.learn2code.AOPDemo.Aspect;

import com.learn2code.AOPDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterReturning(
            pointcut="execution(* com.learn2code.AOPDemo.dao.AccountDAO.findAccounts(..))",
            returning="result"
    )
    public void afterReturningtheAccountMethod(JoinPoint theJointPoint, List<Account> result){
        String method=theJointPoint.getSignature().toShortString();
        System.out.println("\n =======> Executing @Aftereturnning method :- "+method);

        System.out.println("\n ========> the Result is :- "+result);
    }

    @Before("com.learn2code.AOPDemo.Aspect.AOPExpression.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJointPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");
        MethodSignature methodSignature=(MethodSignature) theJointPoint.getSignature();
        System.out.println("Method :- "+methodSignature);

        //display the method argument;
        Object[] theArg=theJointPoint.getArgs();
        for(Object args: theArg){
            System.out.println(args);
            if(args instanceof Account){
                Account theAccount=(Account) args;

                System.out.println("Account Name :- "+theAccount.getName());
                System.out.println("Account Level :- "+theAccount.getLevel());
            }
        }
    }
}
