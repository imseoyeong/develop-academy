package com.example.madangdb_project.controller;

import com.example.madangdb_project.data.dto.OrderDTO;
import com.example.madangdb_project.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/orderinfo")
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

}

// path 변수 : 이전 이후 구분을 위한 변수
// 만약에 이전을 체크 시 path에 before를 넣고, 아니고 이후에 체크한다면 path에 after를 넣어라.

// 만약에 path가 null 이라면 이전/이후 선택하라는 alert 창 노출
// 그게 아니라면 try/catch
//  ㄴ백엔드에 주문정보를 선택한 날짜 데이터를 포함해서 get 요청하고 응답받아 response에 저장
//  ㄴ만약에 상태값이 250이면 setOrderdList 리듀서에 저장
//  ㄴ 아니라면 response.data 값을 setOrderdList에 저장 후 검색 결과 페이지로 이동

