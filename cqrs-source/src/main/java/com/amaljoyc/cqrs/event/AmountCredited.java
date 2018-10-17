package com.amaljoyc.cqrs.event;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Created by amaljoyc on 18.10.18.
 */
@Data
@NoArgsConstructor
public class AmountCredited implements DomainEvent {

    private String accountNumber;
    private AccountProcessType type;
    private Long amount;
    private Instant timestamp;

    public AmountCredited(String accountNumber, Long amount) {
        this.accountNumber = accountNumber;
        this.type = AccountProcessType.CREDIT;
        this.amount = amount;
        this.timestamp = Instant.now();
    }

    @Override
    public String getType() {
        return this.getClass().getName();
    }
}
