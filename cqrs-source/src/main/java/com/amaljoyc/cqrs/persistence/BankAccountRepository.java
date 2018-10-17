package com.amaljoyc.cqrs.persistence;

import com.amaljoyc.cqrs.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by amaljoyc on 17.10.18.
 */
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    Optional<BankAccount> findByAccountNumber(String accountNumber);

}