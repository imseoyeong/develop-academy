package com.example.jpa_example.data.dao;

import com.example.jpa_example.data.entity.BuyEntity;
import com.example.jpa_example.data.entity.UserEntity;
import com.example.jpa_example.data.repository.BuyEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuyDAO {
    private final BuyEntityRepository buyEntityRepository;

    public List<BuyEntity> getAllBuys() {
        return this.buyEntityRepository.findAll();
    }

    public List<BuyEntity> getBuyById(String userid) {
        UserEntity user = new UserEntity();
        user.setUserid(userid);
        return this.buyEntityRepository.findByUser(user);
    }
}
