package model.services.sessions;

import kafka.producer.KafkaProducerFactory;
import log.MemberSessionStartLog;
import log.SessionStartLog;
import model.services.sessions.virtual.VirtualSession;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.LocalDateTime;

public class KafkaSessionService implements SessionService {

    private SessionService ss;
    private KafkaProducer<String, String> kafkaProducer;

    public KafkaSessionService(SessionService ss) {
        this.ss = ss;
        this.kafkaProducer = KafkaProducerFactory.getInstance();
    }

    @Override
    public VirtualSession startSession(long key) {
        SessionStartLog sessionStartLog = new SessionStartLog(LocalDateTime.now());

        VirtualSession virtualSession = ss.startSession(key);

        if (virtualSession.isLoggined()) {
            sessionStartLog = new MemberSessionStartLog(
                    sessionStartLog,
                    virtualSession.getMember()
            );
        }

        kafkaProducer.send(
                new ProducerRecord<>(
                        sessionStartLog.getTopic(),
                        sessionStartLog.toJson()
                ));

        return virtualSession;
    }

    @Override
    public boolean existSession(long key) {
        return ss.existSession(key);
    }
}
