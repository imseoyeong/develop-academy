package com.example.madang_project.controller;

import com.example.madang_project.data.dto.OrderDTO;
import com.example.madang_project.data.entity.BookEntity;
import com.example.madang_project.data.entity.CustomerEntity;
import com.example.madang_project.data.entity.OrderEntity;
import com.example.madang_project.data.repository.OrderEntityRepository;
import com.example.madang_project.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping(value = "before")
    public ResponseEntity<List<OrderDTO>> before(@RequestParam LocalDate date) {
        List<OrderDTO> orderDTOList = this.orderService.getOrderBefore(date);
        if (orderDTOList.isEmpty()) {
            return ResponseEntity.status(250).build();
        }else{
            return ResponseEntity.ok(orderDTOList);
        }
    }

    @GetMapping(value = "after")
    public ResponseEntity<List<OrderDTO>> after(@RequestParam LocalDate date) {
        List<OrderDTO> orderDTOList = this.orderService.getOrderAfter(date);
        if (orderDTOList.isEmpty()) {
            return ResponseEntity.status(250).build();
        }else{
            return ResponseEntity.ok(orderDTOList);
        }
    }

//    @GetMapping(value = "/orderlist")
//    public List<OrderEntity> getOrderList() {
//        return this.orderEntityRepository.findAll();
//    }
//
//    @GetMapping("/order/{id}")
//    public OrderEntity getOrder(@PathVariable Integer id) {
//        OrderEntity order = this.orderEntityRepository.findById(id).orElse(null);
//        CustomerEntity cust = order.getCustid();
//        BookEntity book = order.getBookid();
//        List<OrderEntity> order2 = book.getOrders();
//        System.out.println(cust.getName() + cust.getAddress());
//        return order;
//    }
}
