package com.amaljoyc.cqrs.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by amaljoyc on 17.10.18.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DebitCommand {
    private String accountNumber;
    private Long amount;
}
