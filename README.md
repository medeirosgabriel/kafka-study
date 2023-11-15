# Studying Kafka

## kafka-one-consumer
### Topic: client.orders
### Description:
- #### One Producer
- #### One Consumer

## kafka-multi-consumers
### Topic: ecommerce.orders
### Group ID: client-consumer
### Description:
- #### In this example, we use the same group id for different consumers.
- #### One Producer
- #### N Consumers

## kafka-multi-consumers-2
### Topic: ecommerce.orders
### Group IDs: ecommerce-test-1, ecommerce-test-2
### Description:
- #### In this example, we use different the group ids for different consumers to consume the same messages on a given topic
- #### One Producer
- #### N Consumers