# [Studying Kafka](https://www.youtube.com/watch?v=3xxb_QyrFnw&list=PLXjt2Adje6u7CMQXPsrjqOMF7ibXZ6iLE&index=1)

# Running Kafka
- Download Kafka
- Navigate to the /bin directory
- Run ./zookeeper-server-start.sh ../config/zookeeper.properties
- Run ./kafka-server-start.sh ../config/server.properties
- Run ./kafka-topics.sh --bootstrap-server localhost:9092 --describe

# kafka-one-consumer
### Topic: client.orders
### Steps:
- Run ./kafka-topics.sh --bootstrap-server localhost:9092 --topic client.orders --create --partitions 1
    - Create a topic (clientt.orders) with 1 partition
### Description:
- One Producer
- One Consumer

Obs: the number of partitions is the number of consumers. If you have more consumers, some consumers will not receive messages.

# kafka-multi-consumers
### Topic: ecommerce.orders
### Group ID: client-consumer
### Description:
- In this example, we use the same group id for different consumers.
- One Producer
- N Consumers

# kafka-multi-consumers-2
### Topic: ecommerce.orders
### Group IDs: ecommerce-test-1, ecommerce-test-2
### Description:
- In this example, we use different the group ids for different consumers to consume the same messages on a given topic
- One Producer
- N Consumers
- When a message arrives in the topic, the messages are replicated to the different group ids of that topic
