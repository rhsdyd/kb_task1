package com.kb.shop.controller;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.domain.enums.ShippingStatus;
import com.kb.shop.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
    @Autowired
    private ShippingService shippingService;

    @PostMapping("/")
    public ResponseEntity<ShippingInfo> setShippingInfo(@RequestBody ShippingInfo shippingInfo) {
        Optional<ShippingInfo> newShippinginfo = Optional.of(new ShippingInfo());
        newShippinginfo = ShippingService.setShippingInfo(shippingInfo);

        return newShippinginfo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());


    }


    @GetMapping("/{id}")
    public ResponseEntity<ShippingInfo> getShippingInfo(@PathVariable Long id) {
        ShippingInfo shippingInfo = new ShippingInfo();
        shippingInfo = ShippingService.getShippingInfo(id);

        if (shippingInfo != null) {
            return new ResponseEntity<>(shippingInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShippingInfo> changeStatus(@PathVariable Long id, @RequestParam ShippingStatus newStatus) {
        ShippingInfo shippingInfo = new ShippingInfo();
        shippingInfo= ShippingService.changeStatusByID(id, newStatus);

        if (shippingInfo != null) {
            return new ResponseEntity<>(shippingInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 배송 정보를 생성하는 POST 호출을 생성합니다. (path : /shipping)
    // 배송 Status를 변경하는 PUT 호출을 생성합니다. (path : /shipping)
    // 배송 정보를 확인하는 GET 호출을 생성합니다.  (path : /shipping)

}
