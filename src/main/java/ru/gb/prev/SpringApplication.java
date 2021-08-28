package ru.gb.prev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        Cart cart = context.getBean(Cart.class);
        System.out.println(cart);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        System.out.println(productRepository);
        OrderRepository orderRepository = context.getBean(OrderRepository.class);
        System.out.println(orderRepository);
    }
}
