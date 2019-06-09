package model.services.accounts;

import kafka.producer.KafkaProducerFactory;
import log.AccountOpenLog;
import log.DepositLog;
import log.TransferLog;
import log.WithdrawLog;
import model.entities.accounts.Account;
import model.entities.members.Member;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaMemberAccountService implements AccountService {
    private AccountService as;
    private KafkaProducer<String, String> kafkaProducer;

    public KafkaMemberAccountService(AccountService as) {
        this.as = as;
        this.kafkaProducer = KafkaProducerFactory.getInstance();
    }

    @Override
    public Account open(Member member) {
        Account newAccount = as.open(member);

        AccountOpenLog aol = new AccountOpenLog(newAccount);
        kafkaProducer.send(
                new ProducerRecord<>(
                        aol.getTopic(),
                        aol.toJson()
                ));

        return newAccount;
    }

    @Override
    public boolean deposit(Account account, long amount) {
        if (!as.deposit(account, amount)) {
            return false;
        }

        DepositLog dl = new DepositLog(account, amount);
        kafkaProducer.send(
                new ProducerRecord<>(
                        dl.getTopic(),
                        dl.toJson()
                ));

        return true;
    }

    @Override
    public boolean withdraw(Account account, long amount) {
        if (!as.withdraw(account, amount)) {
            return false;
        }

        WithdrawLog wl = new WithdrawLog(account, amount);
        kafkaProducer.send(
                new ProducerRecord<>(
                        wl.getTopic(),
                        wl.toJson()
                ));

        return true;
    }

    @Override
    public boolean transfer(Account fromAccount, Account toAccount, long amount) {

        if (!as.transfer(fromAccount, toAccount, amount)) {
            return false;
        }

        TransferLog tl = new TransferLog(fromAccount, toAccount, amount);
        kafkaProducer.send(
                new ProducerRecord<>(
                        tl.getTopic(),
                        tl.toJson()
                ));

        return true;
    }

}
