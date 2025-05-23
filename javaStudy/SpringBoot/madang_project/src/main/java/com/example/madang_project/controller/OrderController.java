package com.example.madang_project.controller;

import com.example.madang_project.data.entity.BookEntity;
import com.example.madang_project.data.entity.CustomerEntity;
import com.example.madang_project.data.entity.OrderEntity;
import com.example.madang_project.data.repository.OrderEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderEntityRepository orderEntityRepository;

    @GetMapping(value = "/orderlist")
    public List<OrderEntity> getOrderList() {
        return this.orderEntityRepository.findAll();
    }

    @GetMapping("/order/{id}")
    public OrderEntity getOrder(@PathVariable Integer id) {
        OrderEntity order = this.orderEntityRepository.findById(id).orElse(null);
        CustomerEntity cust = order.getCustid();
        BookEntity book = order.getBookid();
        List<OrderEntity> order2 = book.getOrders();
        System.out.println(cust.getName() + cust.getAddress());
        return order;
    }
}
