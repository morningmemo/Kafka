package service;

import model.dao.members.MemberDaoFactory;
import model.entities.members.Member;
import model.services.customers.CustomerService;
import model.services.customers.CustomerServiceFactory;
import model.services.customers.SimpleCustomerService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceTest {
    @Test
    public void simpleRegisterTest() {
        CustomerService customerService = new SimpleCustomerService(
                MemberDaoFactory.getInstance()
        );

        Member member = new Member();

        member.setName("이종현");
        member.setDateOfBirth(LocalDate.of(1988,3,12));

        Member newMember = customerService.register(member);

        assertEquals(newMember.getId(), 1);
        assertEquals(newMember.getName(), "이종현");
    }

    @Test
    public void kafkaProducerRegisterTest() {
        CustomerService customerService = CustomerServiceFactory.getInstance();

        Member member = new Member();

        member.setName("이종현");
        member.setDateOfBirth(LocalDate.of(1988,3,12));

        Member newMember = customerService.register(member);

        assertEquals(newMember.getId(), 1);
        assertEquals(newMember.getName(), "이종현");
    }
}
