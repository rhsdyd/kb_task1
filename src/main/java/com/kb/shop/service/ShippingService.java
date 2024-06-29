package com.kb.shop.service;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.domain.enums.ShippingStatus;
import com.kb.shop.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ShippingService {

    @Autowired
    private static ShippingRepository shippingRepository;

    public static ShippingInfo getShippingInfo(Long id) {
        return shippingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public static Optional<ShippingInfo> setShippingInfo(ShippingInfo shippingInfo) {
        shippingRepository.save(shippingInfo);
        return shippingRepository.findById(shippingInfo.getId());
    }

    public static ShippingInfo changeStatusByID(Long id, ShippingStatus newStatus) {


        ShippingInfo shippingInfo = getShippingInfo(id);
        shippingInfo.setShippingStatus(newStatus);
        shippingRepository.save(shippingInfo);
        return shippingRepository.save(shippingInfo);

    }


}
