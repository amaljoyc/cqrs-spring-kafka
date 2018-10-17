START TRANSACTION;

INSERT INTO cqrs.bank_account (account_number, balance) VALUES
  (101, 5000);

INSERT INTO cqrs.bank_account (account_number, balance) VALUES
  (102, 3000);

COMMIT;