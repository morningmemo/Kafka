package model.services;

import model.entities.accounts.Account;
import model.entities.members.Member;
import model.services.accounts.AccountService;
import model.services.customers.CustomerService;
import model.services.transfers.DepositService;
import model.services.transfers.TransferService;
import model.services.transfers.WithdrawService;

public interface ServiceFactory {
    CustomerService getCustRegister(Member cust, AccountService aos);
    DepositService getDepositService(Account acc);
    WithdrawService getWithdrawService(Account acc);
    TransferService getTransferService(Account acc);
}
