package com.security_jwt.controller;

import com.security_jwt.data.dto.CoupleDTO;
import com.security_jwt.data.dto.CoupleMatchDTO;
import com.security_jwt.data.dto.CoupleProfileDTO;
import com.security_jwt.data.entity.CoupleMatchEntity;
import com.security_jwt.service.CoupleService;
import com.security_jwt.service.CoupleProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/couple")
public class CoupleController {

    private final CoupleService coupleService;
    private final CoupleProfileService coupleProfileService;

    @PostMapping("/generate-code")
    public ResponseEntity<CoupleDTO> generateCoupleCode(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        String coupleCode = coupleService.generateCoupleCode(username);
        if (coupleCode != null) {
            CoupleDTO response = new CoupleDTO(coupleCode);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    @PostMapping("/match")
    public ResponseEntity<CoupleMatchDTO> matchCouple(@AuthenticationPrincipal UserDetails userDetails, @RequestBody CoupleDTO coupleDTO) {
        String username = userDetails.getUsername();
        CoupleMatchEntity coupleMatch = coupleService.matchCouple(username, coupleDTO.getCoupleCode());
        if (coupleMatch != null) {
            String partnerUsername;
            if (coupleMatch.getPart1().getUsername().equals(username)) {
                partnerUsername = coupleMatch.getPart2().getUsername();
            } else {
                partnerUsername = coupleMatch.getPart1().getUsername();
            }

            CoupleMatchDTO response = CoupleMatchDTO.builder()
                    .coupleCode(coupleMatch.getCode())
                    .partnerUsername(partnerUsername)
                    .build();
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/update-profile")
    public ResponseEntity<CoupleProfileDTO> updateCoupleProfile(@AuthenticationPrincipal UserDetails userDetails,
                                                                @ModelAttribute CoupleProfileDTO coupleProfileDTO) {
        String username = userDetails.getUsername();
        CoupleProfileDTO updatedProfile = coupleProfileService.updateCoupleProfile(coupleProfileDTO, username);
        if (updatedProfile != null) {
            return ResponseEntity.ok(updatedProfile);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/dissolve")
    public ResponseEntity<Void> dissolveCouple(@RequestBody CoupleDTO coupleDTO) {
        boolean dissolved = coupleProfileService.dissolveCouple(coupleDTO.getCoupleCode());
        if (dissolved) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/{coupleCode}")
    public ResponseEntity<CoupleProfileDTO> getCoupleProfile(@PathVariable String coupleCode) {
        CoupleProfileDTO coupleProfile = coupleProfileService.getCoupleProfile(coupleCode);
        if (coupleProfile != null) {
            return ResponseEntity.ok(coupleProfile);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
