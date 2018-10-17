package com.amaljoyc.cqrs.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Created by amaljoyc on 18.10.18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmountDebited implements DomainEvent {

    private String accountNumber;
    private AccountProcessType type;
    private Long amount;
    private Instant timestamp;

    public AmountDebited(String accountNumber, Long amount) {
        this.accountNumber = accountNumber;
        this.type = AccountProcessType.DEBIT;
        this.amount = amount;
        this.timestamp = Instant.now();
    }

    @Override
    public String getType() {
        return this.getClass().getName();
    }
}
