package com.example.jpa_example.service;

import com.example.jpa_example.data.dao.BuyDAO;
import com.example.jpa_example.data.dto.BuyDTO;
import com.example.jpa_example.data.entity.BuyEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyService {
    private final BuyDAO buyDAO;

    public List<BuyDTO> getAllBuys() {
        List<BuyDTO> buyDTOList = new ArrayList<>();
        List<BuyEntity> buyEntities = this.buyDAO.getAllBuys();
        for (BuyEntity buyEntity : buyEntities) {
            BuyDTO buyDTO = BuyDTO.builder()
                    .id(buyEntity.getId())
                    .userid(buyEntity.getUser().getUserid())
                    .prodname(buyEntity.getProdname())
                    .groupname(buyEntity.getGroupname())
                    .price(buyEntity.getPrice())
                    .amount(buyEntity.getAmount())
                    .build();
            buyDTOList.add(buyDTO);
        }
        return buyDTOList;
    }

    public List<BuyDTO> buyHistoryByUserid(String userid) {
        List<BuyDTO> buyDTOList = new ArrayList<>();
        List<BuyEntity> buyEntities = this.buyDAO.getBuyById(userid);
        for (BuyEntity buyEntity : buyEntities) {
            BuyDTO buyDTO = BuyDTO.builder()
                    .id(buyEntity.getId())
                    .userid(buyEntity.getUser().getUserid())
                    .prodname(buyEntity.getProdname())
                    .groupname(buyEntity.getGroupname())
                    .price(buyEntity.getPrice())
                    .amount(buyEntity.getAmount())
                    .build();
            buyDTOList.add(buyDTO);
        }
        return buyDTOList;
    }
}
