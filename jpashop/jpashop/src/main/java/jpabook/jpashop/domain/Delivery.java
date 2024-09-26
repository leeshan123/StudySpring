package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery",fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    //ORDINAL 쓰면 0,1 이런식이라 1개가 들어가면 싹 다 바껴서 장애남
    //STRING으로 쓰는걸 권장
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //READY,COMP
}
