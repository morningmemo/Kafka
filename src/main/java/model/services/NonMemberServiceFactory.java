package model.services;

import model.entities.accounts.Account;
import model.entities.members.Member;
import model.services.accounts.AccountService;
import model.services.customers.CustomerService;
import model.services.transfers.DepositService;
import model.services.transfers.TransferService;
import model.services.transfers.WithdrawService;

public class NonMemberServiceFactory implements ServiceFactory {
    @Override
    public CustomerService getCustRegister(Member cust, AccountService aos) {
//        return new CustomerService();
        return null;
    }

    @Override
    public DepositService getDepositService(Account acc) {
        throw new UnsupportedOperationException();
    }

    @Override
    public TransferService getTransferService(Account acc) {
        throw new UnsupportedOperationException();
    }

    @Override
    public WithdrawService getWithdrawService(Account acc) {
        throw new UnsupportedOperationException();
    }
}
