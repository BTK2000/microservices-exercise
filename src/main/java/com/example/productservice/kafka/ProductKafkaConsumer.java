package com.example.productservice.kafka;

import com.example.productservice.dto.CartEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductKafkaConsumer {

    @KafkaListener(topics = "cart-topic", groupId = "product-group")
    public void consumeCartEvent(CartEvent cartEvent) {
        System.out.println("Received Kafka event in product-service:");
        System.out.println("Cart ID: " + cartEvent.getCartId());
        System.out.println("Product ID: " + cartEvent.getProductId());
        System.out.println("Quantity: " + cartEvent.getQuantity());
    }
}