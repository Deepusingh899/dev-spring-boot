package com.learn2code.AOPDemo.dao;

import com.learn2code.AOPDemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements  AccountDAO{

    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass()+ ": DOING MY DB WORK :- Adding Account");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+ ": DOING MY Work");
        return false;
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> myAccounts=new ArrayList<>();

        //create a sample account
        Account temp1=new Account("John","Gold");
        Account temp2=new Account("Madhu","Platinum");
        Account temp3=new Account("Luca","Gold");

        // add the accounts to the list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

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
}
