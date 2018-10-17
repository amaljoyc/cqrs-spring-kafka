START TRANSACTION;

CREATE SCHEMA IF NOT EXISTS cqrs;

-- bank_account table is used by the source service
CREATE TABLE cqrs.bank_account
(
  id SERIAL NOT NULL,
  account_number CHARACTER VARYING(255) NOT NULL,
  balance BIGINT,
  CONSTRAINT bank_account_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);

-- transaction table is used by the sink service
CREATE TABLE cqrs.transaction
(
  id SERIAL NOT NULL,
  account_number CHARACTER VARYING(255) NOT NULL,
  type CHARACTER VARYING(20),
  amount BIGINT,
  creation_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT transaction_pkey PRIMARY KEY (id)
)
WITH (
OIDS = FALSE
);

COMMIT;