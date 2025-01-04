package com.learn2code.AOPDemo.Aspect;

import com.learn2code.AOPDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

    @AfterThrowing  (
            pointcut="execution(* com.learn2code.AOPDemo.dao.AccountDAO.findAccounts(..))",
            throwing="theExc"
    )
    public void afterReturningFindAccountAdvice(JoinPoint theJointPoint ,Throwable theExc){
        //print out which method are you adviced
        String method=theJointPoint.getSignature().toShortString();
        System.out.println("\n =======> Executing @AfterThrowing method :- "+method);

        //log the exception
        System.out.println("\n ========> the Exception is :- "+theExc);

    }

    @AfterReturning(
            pointcut="execution(* com.learn2code.AOPDemo.dao.AccountDAO.findAccounts(..))",
            returning="result"
    )
    public void afterReturningtheAccountMethod(JoinPoint theJointPoint, List<Account> result){
        String method=theJointPoint.getSignature().toShortString();
        System.out.println("\n =======> Executing @Aftereturnning method :- "+method);

        System.out.println("\n ========> the Result is :- "+result);

        //Do Post-process
        // Convert Account name to upperCase
        converAccountNameToUpperCase(result);

        System.out.println("\n ========> the Result is :- "+result);
    }

    private void converAccountNameToUpperCase(List<Account> result) {
        //loop through the Account Name
        for(Account name:result){
            //get the name and convert to upper case
            String tempName=name.getName().toUpperCase();

            //update the Name to the account
            name.setName(tempName);

        }
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
