package model.entities.members;

import model.entities.accounts.Account;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Member {
    private long id;
    private String name;
    private LocalDate dateOfBirth;
    private String accountNumber;
    private Account account;
    private long sessionCount;
    private LocalDateTime createdAt;

    public Member() {}

    public Member(Member member) {
        this.id = member.id;
        this.name = member.name;
        this.account = member.account;
        this.dateOfBirth = member.dateOfBirth;
        this.accountNumber = member.accountNumber;
        this.sessionCount = member.sessionCount;
        this.createdAt = member.createdAt;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
        this.accountNumber = account.getAccountNumber();
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
