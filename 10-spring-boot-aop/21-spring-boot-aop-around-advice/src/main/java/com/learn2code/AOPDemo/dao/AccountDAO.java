package com.learn2code.AOPDemo.dao;

import com.learn2code.AOPDemo.Account;

import java.util.List;

public interface AccountDAO {


    public void addAccount(Account theAccount,boolean vipFlag);

    boolean doWork();

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);

    public String getName();
    public void setName(String name);

    public String getServiceCode();
    public void setServiceCode(String serviceCode);

}
