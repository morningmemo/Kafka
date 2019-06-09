CREATE TABLE members (
                        member_id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                        name VARCHAR(50) NOT NULL,
                        date_of_birth DATE NOT NULL,
                        account_number VARCHAR(50),
                        created_at TIMESTAMP(9)
);

CREATE TABLE accounts (
                        account_number VARCHAR(50) NOT NULL UNIQUE,
                        amount BIGINT NOT NULL,
                        created_at TIMESTAMP(9)
);

CREATE TABLE transactions_recently (
                        account_number VARCHAR(50) NOT NULL,
                        transaction_id BIGINT NOT NULL,
                        created_at TIMESTAMP(9)
);

CREATE TABLE transactions_metadata (
                        account_number VARCHAR(50) NOT NULL,
                        min_transaction_amount BIGINT NOT NULL,
                        max_transaction_amount BIGINT NOT NULL,
                        created_at TIMESTAMP(9)
);