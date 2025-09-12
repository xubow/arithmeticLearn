package spring.stateMachine;

import lombok.Data;

/**
 * @author chenyves
 * @description: (请在此添加描述)
 * @date 2025/1/7 10:13
 * @since JDK 1.8
 */

public class Order {

    private Long id;

    private OrderStatusEnum orderstatus;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderstatus=" + orderstatus +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatusEnum getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(OrderStatusEnum orderstatus) {
        this.orderstatus = orderstatus;
    }
}