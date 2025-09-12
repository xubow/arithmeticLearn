package spring.stateMachine;

import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chenyves
 * @description: (请在此添加描述)
 * @date 2025/1/7 10:10
 * @since JDK 1.8
 */
@Transactional
@WithStateMachine
public class OrderStatusMachineListener {

    @OnTransition(source = "WAIT_PAY", target = "WAIT_DELIVERY")
    public boolean payTransition(Message message) {
        Order order = (Order) message.getHeaders().get("order");
        if (order == null) {
            return false;
        }
        order.setOrderstatus(OrderStatusEnum.WAIT_DELIVERY);
        System.out.println("支付，状态机反馈信息：" + message.getHeaders());
        System.out.println("支付，状态机订单信息：" + order);
        return true;
    }

    @OnTransition(source = "WAIT_DELIVERY", target = "WAIT_RECEIVED")
    public boolean deliveryTransition(Message message) {
        Order order = (Order) message.getHeaders().get("order");
        if (order == null) {
            return false;
        }
        order.setOrderstatus(OrderStatusEnum.WAIT_RECEIVED);
        System.out.println("发货，状态机反馈信息：" + message.getHeaders().toString());
        System.out.println("发货，状态机订单信息：" + order);
        return true;
    }

    @OnTransition(source = "WAIT_RECEIVED", target = "FINISH")
    public boolean receiveTransition(Message message) {
        Order order = (Order) message.getHeaders().get("order");
        if (order == null) {
            return false;
        }
        order.setOrderstatus(OrderStatusEnum.FINISH);
        System.out.println("收货，状态机反馈信息：" + message.getHeaders().toString());
        System.out.println("收货，状态机订单信息：" + order);
        return true;
    }
}