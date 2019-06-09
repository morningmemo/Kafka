package log;

import kafka.TopicType;
import model.entities.accounts.Account;

import java.time.LocalDateTime;

public class WithdrawLog extends Log {
    private final long memberId;
    private final String accountNumber;
    private final long amount;
    private final LocalDateTime withdrawAt;

    public WithdrawLog(Account account, long amount) {
        this.memberId = account.getMember().getId();
        this.accountNumber = account.getAccountNumber();
        this.amount = amount;
        this.withdrawAt = LocalDateTime.now();
    }

    @Override
    public String getTopic() {
        return TopicType.WITHDRAW.toString();
    }
}
