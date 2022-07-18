package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")  // FK보유 OWNER가 여기
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)  // persist를 연관관계 객체에 전파
    private List<OrderItem> orderItem = new ArrayList<>();

    @OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL) // order 만 persist하면  delivery 도 같이 persist 됨
    @JoinColumn(name="delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    @Enumerated( EnumType.STRING)
    private OrderStatus status;

    // 연관관계 편의 메소드
    public void setMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        this.orderItem.add(orderItem);
        orderItem.setOrder(this);
    }

    // 연관관계 편의 메소드
    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);

    }



}
