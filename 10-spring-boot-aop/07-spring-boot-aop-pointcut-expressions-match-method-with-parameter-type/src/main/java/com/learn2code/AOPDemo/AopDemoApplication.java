package com.learn2code.AOPDemo;

import com.learn2code.AOPDemo.dao.AccountDAO;
import com.learn2code.AOPDemo.dao.MemberShipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberShipDAO memberShipDAO){
		return runner -> {
			demoTheBeforeAdvice(accountDAO,memberShipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {
		Account myAccount=new Account();
		accountDAO.addAccount(myAccount);
		memberShipDAO.addSillyMember();
	}
}
