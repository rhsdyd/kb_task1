package com.kb.shop.domain;

import com.kb.shop.domain.enums.ShippingStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ShippingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ShippingStatus shippingStatus;

    @ManyToOne(fetch = FetchType.LAZY) // 데이터는 실제로 접근할 때 로드됨, 데이터를 접근할 때마다 추가적인 데이터베이스 쿼리가 발생
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderItem_id")
    private OrderItem orderItem;



    // Order id
    // OrderItem id
    // shippingStatus

}
