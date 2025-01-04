package com.learn2code.AOPDemo.dao;

import com.learn2code.AOPDemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements  AccountDAO{

    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println(getClass()+ ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+ ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+ ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+ ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass()+ ": DOING MY DB WORK :- Adding Account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+ ": DOING MY Work");
        return false;
    }
}
