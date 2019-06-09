package log;

import kafka.TopicType;
import model.entities.accounts.Account;

import java.time.LocalDateTime;

public class AccountOpenLog extends Log {
    private final long memberId;
    private final String accountNumber;
    private final LocalDateTime openAt;

    public AccountOpenLog(Account account) {
        this.memberId = account.getMember().getId();
        this.accountNumber = account.getAccountNumber();
        this.openAt = account.getCreatedAt();
    }

    @Override
    public String getTopic() {
        return TopicType.ACCOUNT_OPEN.toString();
    }
}
