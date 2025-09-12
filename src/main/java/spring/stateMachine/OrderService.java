package spring.stateMachine;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chenyves
 * @description: (请在此添加描述)
 * @date 2025/1/7 10:22
 * @since JDK 1.8
 */
@Service
public class OrderService {

    @Resource
    private StateMachine<OrderStatusEnum, OrderStatusTransitionEventEnum> orderStateMachine;

    private long id = 1L;
    private Map<Long, Order> orders = new ConcurrentHashMap<>();

    public Map<Long, Order> getOrders() {
        return orders;
    }

    public Order create() {
        Order order = new Order();
        order.setOrderstatus(OrderStatusEnum.WAIT_PAY);
        order.setId(id++);
        orders.put(order.getId(), order);
        System.out.println("订单创建成功:" + order.toString());
        return order;
    }

    public Order pay(long id) {
        Order order = orders.get(id);
        System.out.println("尝试支付，订单号：" + id);
        Message message = MessageBuilder.withPayload(OrderStatusTransitionEventEnum.PAYED).
                setHeader("order", order).build();
        if (!sendEvent(message)) {
            System.out.println(" 支付失败, 状态异常，订单号：" + id);
        }
        return orders.get(id);
    }


    public Order deliver(long id) {
        Order order = orders.get(id);
        System.out.println(" 尝试发货，订单号：" + id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusTransitionEventEnum.DELIVERY)
                .setHeader("order", order).build())) {
            System.out.println(" 发货失败，状态异常，订单号：" + id);
        }
        return orders.get(id);
    }


    public Order receive(long id) {
        Order order = orders.get(id);
        System.out.println(" 尝试收货，订单号：" + id);
        if (!sendEvent(MessageBuilder.withPayload(OrderStatusTransitionEventEnum.RECEIVED)
                .setHeader("order", order).build())) {
            System.out.println(" 收货失败，状态异常，订单号：" + id);
        }
        return orders.get(id);
    }


    /**
     * 发送状态转换事件
     * @param message
     * @return
     */
    private synchronized boolean sendEvent(Message<OrderStatusTransitionEventEnum> message) {
        boolean result = false;
        try {
            orderStateMachine.start();
            result = orderStateMachine.sendEvent(message);
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        } finally {
            if (Objects.nonNull(message)) {
                Order order = (Order) message.getHeaders().get("order");
                if (Objects.nonNull(order) && Objects.equals(order.getOrderstatus(), OrderStatusEnum.FINISH)) {
                    orderStateMachine.stop();
                }
            }
        }
        return result;
    }
}
