package com.example.jpa_example.controller;

import com.example.jpa_example.data.dto.BuyDTO;
import com.example.jpa_example.data.entity.BuyEntity;
import com.example.jpa_example.service.BuyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BuyController {
    private final BuyService buyService;

    // 모든 구매 내역
    @GetMapping(value = "/buy-list")
    public List<BuyDTO> buyList() {
        return this.buyService.getAllBuys();
    }

    @GetMapping(value = "buy-history/{userid}")
    public List<BuyDTO> userBuyHistoryByUserid(@PathVariable String userid) {
        return this.buyService.buyHistoryByUserid(userid);
    }
}
