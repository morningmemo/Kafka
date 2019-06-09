package log;

import kafka.TopicType;
import model.entities.accounts.Account;

import java.time.LocalDateTime;

public class DepositLog extends Log {
    private final long memberId;
    private final String accountNumber;
    private final long amount;
    private final LocalDateTime depositAt;

    public DepositLog(Account account, long amount) {
        this.memberId = account.getMember().getId();
        this.accountNumber = account.getAccountNumber();
        this.amount = amount;
        this.depositAt = LocalDateTime.now();
    }

    @Override
    public String getTopic() {
        return TopicType.DEPOSIT.toString();
    }
}
