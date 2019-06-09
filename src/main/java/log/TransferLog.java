package log;

import kafka.TopicType;
import model.entities.accounts.Account;

import java.time.LocalDateTime;

public class TransferLog extends Log {
    private final long memberId;
    private final String fromAccountNumber;
    private final String toAccountNumber;
    private final long amount;
    private final LocalDateTime transferAt;

    public TransferLog(Account fromAccount, Account toAccount, long amount) {
        this.memberId = fromAccount.getMember().getId();
        this.fromAccountNumber = fromAccount.getAccountNumber();
        this.toAccountNumber = toAccount.getAccountNumber();
        this.amount = amount;
        this.transferAt = LocalDateTime.now();
    }

    @Override
    public String getTopic() {
        return TopicType.TRANSFER.toString();
    }
}
