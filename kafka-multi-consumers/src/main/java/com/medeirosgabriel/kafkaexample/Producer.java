package com.medeirosgabriel.kafkaexample;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Producer {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        KafkaProducer producer = new KafkaProducer<String, String>(properties());

        Callback callback = (data, error) -> {
            if (error != null) {
                error.printStackTrace();
                return;
            }
            System.out.println("message published successfully");
            System.out.println(data.partition());
            System.out.println(data.offset());
        };

        for (int i = 0; i < 10; i++) {
            ProducerRecord record = new ProducerRecord<>("ecommerce.orders", "client" + i, "order:" + i + " dollars"); // key + i == different partitions
            producer.send(record, callback).get();
        }
    }

    private static Properties properties() {
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return properties;
    }
}
