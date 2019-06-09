package model.services.customers;

import kafka.producer.KafkaProducerFactory;
import log.RegisterLog;
import model.entities.members.Member;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaCustomerService implements CustomerService {
    private CustomerService cs;
    private KafkaProducer<String, String> kafkaProducer;

    public KafkaCustomerService(CustomerService cs) {
        this.cs = cs;
        this.kafkaProducer = KafkaProducerFactory.getInstance();
    }

    @Override
    public Member register(Member member) {
        Member newMember = this.cs.register(member);

        RegisterLog rl = new RegisterLog(newMember);

        kafkaProducer.send(
                new ProducerRecord<>(
                        rl.getTopic(),
                        rl.toJson()
                ));

        return newMember;
    }
}
