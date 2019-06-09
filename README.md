# Kafka

local에서 kafka broker 및 zookeeper 실행

zookeeper-server-start /usr/local/etkafka/zookeeper.properties

kafka-server-start /usr/local/etc/kafka/server.properties

listeners=PLAINTEXT://:9092

test -> java -> TestDataGenerator -> DataGeneratorSimulatorTest -> dataGeneratorSimulationTest() 실행
