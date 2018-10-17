package com.amaljoyc.cqrs.application;

import com.amaljoyc.cqrs.event.AmountCredited;
import com.amaljoyc.cqrs.event.AmountDebited;
import com.amaljoyc.cqrs.event.DomainEventPublisher;
import com.amaljoyc.cqrs.model.BankAccount;
import com.amaljoyc.cqrs.persistence.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by amaljoyc on 17.10.18.
 */
@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired
    private DomainEventPublisher domainEventPublisher;

    @Transactional
    public void creditAmount(String accountNumber, Long amount) {
        BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Invalid accountNumber :" + accountNumber));

        bankAccount.credit(amount);
        domainEventPublisher.publish(new AmountCredited(accountNumber, amount));
    }

    @Transactional
    public void debitAmount(String accountNumber, Long amount) {
        BankAccount bankAccount = bankAccountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Invalid accountNumber :" + accountNumber));

        bankAccount.debit(amount);
        domainEventPublisher.publish(new AmountDebited(accountNumber, amount));
    }
}
