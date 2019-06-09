package model.services;

import model.entities.accounts.Account;
import model.entities.members.Member;
import model.services.accounts.AccountService;
import model.services.customers.CustomerService;
import model.services.transfers.DepositService;
import model.services.transfers.TransferService;
import model.services.transfers.WithdrawService;

public class MemberServiceFactory implements ServiceFactory {
    @Override
    public CustomerService getCustRegister(Member cust, AccountService aos) {
        throw new UnsupportedOperationException();
    }

    @Override
    public DepositService getDepositService(Account acc) {
        return null;
//        return new DepositService();
    }

    @Override
    public TransferService getTransferService(Account acc) {
        return null;
//        return new TransferService();
    }

    @Override
    public WithdrawService getWithdrawService(Account acc) {
        return null;
//        return new WithdrawService();
    }
}
