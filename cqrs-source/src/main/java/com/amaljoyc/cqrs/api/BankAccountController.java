package com.amaljoyc.cqrs.api;

import com.amaljoyc.cqrs.application.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amaljoyc on 17.10.18.
 */
@RestController("/bankAccount")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @PostMapping("/credit")
    ResponseEntity credit(@RequestBody CreditCommand creditCommand) {
        bankAccountService.creditAmount(creditCommand.getAccountNumber(), creditCommand.getAmount());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/debit")
    ResponseEntity debit(@RequestBody DebitCommand debitCommand) {
        bankAccountService.debitAmount(debitCommand.getAccountNumber(), debitCommand.getAmount());
        return ResponseEntity.ok().build();
    }
}
