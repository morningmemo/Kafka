package model.entities.accounts;

import model.entities.accounts.accountnumber.SimpleAccountNumberGenerator;
import model.entities.members.Member;

import java.time.LocalDateTime;

public class Account {
    private final String accountNumber;
    private long amount;
    private final Member member;
    private LocalDateTime createdAt;

    public Account(Account account) {
        this.accountNumber = account.getAccountNumber();
        this.member = account.getMember();
        this.amount = account.getAmount();
    }

    public Account(Member member) {
        this.accountNumber = SimpleAccountNumberGenerator.generateAccountNumber();
        this.member = member;
        this.amount = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getAmount() {
        return amount;
    }

    public Member getMember() {
        return member;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public long decreaseAmount(long amount) throws IllegalArgumentException {
        long decreased = this.amount - amount;
        if (decreased < 0) {
            throw new IllegalArgumentException("고객의 계좌 잔액은 0원 미만이 될수 없습니다.");
        }

        this.amount = decreased;
        return this.amount;
    }

    public long increaseAmount(long amount) throws IllegalArgumentException {
        long increased = this.amount + amount;
        if (increased >= Long.MAX_VALUE) {
            throw new IllegalArgumentException("고객의 계좌 잔액은 " + Long.MAX_VALUE + "원 이상이 될 수 없습니다.");
        }

        this.amount = increased;
        return this.amount;
    }
}
