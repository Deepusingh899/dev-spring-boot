package com.learn2code.AOPDemo.dao;

import com.learn2code.AOPDemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements  AccountDAO{
    @Override
    public void addAccount(Account theAccount) {
        System.out.println(getClass()+ " DOING MY DB WORK :- Adding Account");
    }
}
