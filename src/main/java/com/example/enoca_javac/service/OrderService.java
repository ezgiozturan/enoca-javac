package com.example.enoca_javac.service;

import com.example.enoca_javac.entity.Cart;
import com.example.enoca_javac.entity.Order;
import com.example.enoca_javac.repository.CartRepository;
import com.example.enoca_javac.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    public Order placeOrder(long customerId){

        Cart cart = cartRepository.findByCustomerId(customerId);
               //EXCEPTİON

        if (cart.getProducts().isEmpty()) {
            //EXCEPTİON
        }

        Order order = new Order();
        order.setCustomer(cart.getCustomer());
        order.setTotalPrice(cart.getTotalPrice());

        orderRepository.save(order);

        cart.getProducts().clear();
        cart.calculateTotalPrice();
        cartRepository.save(cart);

        return order;
    };

    public Order getOrderForCode(String orderCode){
        return orderRepository.findByOrderCode(orderCode);
           //exception


    };


}
