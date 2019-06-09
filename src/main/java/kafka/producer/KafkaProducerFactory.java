package kafka.producer;

import log.Log;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class KafkaProducerFactory {
    private final static String BOOTSTRAP_DEFAULT_SERVER = "localhost:9092";
    private final static String BOOTSTRAP_SERVER = BOOTSTRAP_DEFAULT_SERVER;

    private static KafkaProducer<String, String> producer;

    private static class producerContainerHolder {
        private static final ConcurrentMap<Class<? extends Log>, Object> PRODUCERS = new ConcurrentHashMap<>();
    }

    public static synchronized KafkaProducer<String, String> getInstance() {
        if (producer == null) {
            producer = createProducer(String.class);
        }
        return producer;
    }

    public static synchronized <E extends Log> KafkaProducer<String, E> getInstance(Class<E> logClass) {
        @SuppressWarnings("unchecked")
        KafkaProducer<String, E> producer = (KafkaProducer<String, E>) producerContainerHolder.PRODUCERS.get(logClass);
        if (producer == null) {
            producer = createProducer(logClass);
        }
        return producer;
    }

    private static <E> KafkaProducer<String, E> createProducer(Class<?> logClass) {
        Properties props = new Properties();

        setupBootstrapAndSerializers(props);
        setupBatchingAndCompression(props);

        return new KafkaProducer<>(props);
    }

    private static void setupBootstrapAndSerializers(final Properties props) {
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                BOOTSTRAP_SERVER);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaProducer");
        props.put(ProducerConfig.ACKS_CONFIG, "0");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
    }

    private static void setupBatchingAndCompression(final Properties props) {
        props.put(ProducerConfig.LINGER_MS_CONFIG, 0);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 65536);
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "gzip");
    }
}
