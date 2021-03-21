package com.bank;

import com.bank.model.Account;
import com.bank.model.City;
import com.bank.model.Customer;
import com.bank.repository.AccountRepository;
import com.bank.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication

public class BankApplication implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public BankApplication(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }


    public static void  main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Customer c1 = Customer.builder()
                .id("123456")
                .name("Reşat")
                .address("Ev")
                .city(City.ISTANBUL)
                .dateOfBirth(1988)
                .build();
        Customer c2 = Customer.builder()
                .id("123457")
                .name("Onur")
                .address("Ev")
                .city(City.ANKARA)
                .dateOfBirth(1988)
                .build();
        Customer c3 = Customer.builder()
                .id("123458")
                .name("KURT")
                .address("Ev")
                .city(City.IZMIR)
                .dateOfBirth(1988)
                .build();
        customerRepository.saveAll(Arrays.asList(c1,c2,c3));

        Account a1= Account.builder()
                .id("100")
                .customerId("123456")
                .city(City.ISTANBUL)
                .balance(1320.0)
                .build();
        Account a2= Account.builder()
                .id("101")
                .customerId("123457")
                .city(City.ANKARA)
                .balance(13200.0)
                .build();
        Account a3= Account.builder()
                .id("102")
                .customerId("123458")
                .city(City.ISTANBUL)
                .balance(130.0)
                .build();
        accountRepository.saveAll(Arrays.asList(a1,a2,a3));


    }
}
