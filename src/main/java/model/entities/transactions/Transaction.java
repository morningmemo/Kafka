package model.entities.transactions;

import java.time.LocalDateTime;

public class Transaction {
    private long id;
    private long memberNumber;
    private long fromAccountNumber;
    private long toAccountNumber;
    private long amount;
    private LocalDateTime createdAt;
}
