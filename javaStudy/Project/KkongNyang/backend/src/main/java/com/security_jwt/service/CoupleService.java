package com.security_jwt.service;

import com.security_jwt.data.dao.CoupleDAO;
import com.security_jwt.data.entity.CoupleMatchEntity;
import com.security_jwt.data.entity.ProfileEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CoupleService {

    private final CoupleDAO coupleDAO;

    public String generateCoupleCode(String username) {
        String coupleCode = UUID.randomUUID().toString();
        ProfileEntity profile = coupleDAO.saveCoupleCode(username, coupleCode);
        if (profile != null) {
            return coupleCode;
        }
        return null;
    }

    public CoupleMatchEntity matchCouple(String username, String coupleCode) {
        ProfileEntity partnerProfile = coupleDAO.findByCoupleCode(coupleCode);
        if (partnerProfile != null) {
            CoupleMatchEntity coupleMatch = coupleDAO.matchCouple(username, partnerProfile.getUsername(), coupleCode);
            if (coupleMatch != null) {
                // Update couplecode for both profiles in profiletbl
                ProfileEntity userProfile = coupleDAO.saveCoupleCode(username, coupleCode);
                ProfileEntity partnerUpdatedProfile = coupleDAO.saveCoupleCode(partnerProfile.getUsername(), coupleCode);
                if (userProfile != null && partnerUpdatedProfile != null) {
                    return coupleMatch;
                }
            }
        }
        return null;
    }
}
