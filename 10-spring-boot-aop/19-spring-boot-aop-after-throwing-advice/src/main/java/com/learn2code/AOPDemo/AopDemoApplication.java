package com.learn2code.AOPDemo;

import com.learn2code.AOPDemo.dao.AccountDAO;
import com.learn2code.AOPDemo.dao.MemberShipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberShipDAO memberShipDAO){
		return runner -> {
//			demoTheBeforeAdvice(accountDAO,memberShipDAO);
//			dempTheAfterReturningAdvice(accountDAO);
			demoTheAfterThrowingAdvice(accountDAO);
		};
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> theAccount=null;
		try{
			boolean tripWire=true;
			theAccount=accountDAO.findAccounts(tripWire);
		}catch(Exception exc){
			System.out.println("\n\n Main Programe :-  caought exception :-"+exc);
		}

		// display the accounts
		System.out.println("\n\nMain Programs: demoAfterReturningAdvice");
		System.out.println("--------------------------------------------");

		System.out.println(theAccount);
		System.out.println("\n");
	}

	private void dempTheAfterReturningAdvice(AccountDAO accountDAO) {
		// call the method to find the account
		List<Account> theAccount=accountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Programs: demoAfterReturningAdvice");
		System.out.println("--------------------------------------------");

		System.out.println(theAccount);
		System.out.println("\n");

	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
		Account myAccount=new Account();
		myAccount.setName("Deepali");
		myAccount.setLevel("1");
		accountDAO.addAccount(myAccount,true);	
		accountDAO.doWork();

		accountDAO.setName("Deepak Singh");
		accountDAO.setServiceCode("ABC001");

		String name=accountDAO.getName();
		String serviceCode=accountDAO.getServiceCode();

		memberShipDAO.addSillyMember();
		memberShipDAO.goToSleep();
	}
}
