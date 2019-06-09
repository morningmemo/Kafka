package TestDataGenerator.bot.actions;

import TestDataGenerator.NameGenerator;
import TestDataGenerator.bot.Bot;
import model.entities.members.Member;
import model.services.customers.CustomerService;
import model.services.customers.CustomerServiceFactory;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Register extends ActionChain {


    private static final long minDay = LocalDate.of(1920, 1, 1).toEpochDay();
    private static final long maxDay = LocalDate.of(2000, 12, 31).toEpochDay();

    Register(Bot bot) {
        super(bot, new AccountOpen(bot));
    }

    @Override
    protected void doAction() {

        CustomerService customerService = CustomerServiceFactory.getInstance();

        Member member = new Member();

        member.setName(NameGenerator.generateRandomName());
        member.setDateOfBirth(generateRandomBirth());

        getBot().getSession().setMember(customerService.register(member));
    }

    private static LocalDate generateRandomBirth() {
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }
}
