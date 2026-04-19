package com.example.productservice.kafka;

import com.example.productservice.dto.CartEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductKafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(ProductKafkaConsumer.class);

    @KafkaListener(topics = "cart-topic", groupId = "product-group")
    public void consumeCartEvent(CartEvent cartEvent) {
        log.info("Kafka event received in product-service: cartId={}, productId={}, quantity={}",
                cartEvent.getCartId(),
                cartEvent.getProductId(),
                cartEvent.getQuantity());
    }
}