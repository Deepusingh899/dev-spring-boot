package com.learn2code.AOPDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDAOImpl implements  MemberShipDAO{
    @Override
    public boolean addSillyMember() {
        System.out.println(getClass()+ " DOING MY DB WORK :- Membership Account");
        return true;
    }
}
