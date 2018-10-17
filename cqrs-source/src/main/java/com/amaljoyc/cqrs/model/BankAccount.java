package com.amaljoyc.cqrs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by amaljoyc on 17.10.18.
 */
@Entity
@NoArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue
    @Getter
    private Long id;

    private String accountNumber;
    private Long balance;

    public void credit(Long amount) {
        balance += amount;
    }

    public void debit(Long amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Not enough balance available for debit");
        }

        balance -= amount;
    }
}
