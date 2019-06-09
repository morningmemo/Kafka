package model.services.customers;

import model.dao.members.MemberDaoFactory;

public class CustomerServiceFactory {
    private static CustomerService customerService;
    public static synchronized CustomerService getInstance() {
        if (customerService == null) {
            customerService = new KafkaCustomerService(
                    new SimpleCustomerService(MemberDaoFactory.getInstance())
            );
        }
        return customerService;
    }
}
