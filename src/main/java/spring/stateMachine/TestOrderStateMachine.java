package spring.stateMachine;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.mybatis.AppConfig;

/**
 * @author chenyves
 * @description: (请在此添加描述)
 * @date 2025/1/7 10:31
 * @since JDK 1.8
 */
public class TestOrderStateMachine {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(OrderStatusMachineConfig.class);
        context.refresh();
        OrderService orderService = (OrderService) context.getBean("orderService");
        orderService.create();
//        orderService.create();
        orderService.pay(1L);
        orderService.deliver(1L);
        orderService.receive(1L);
//        orderService.pay(2L);
//        orderService.deliver(2L);
//        orderService.receive(2L);
        System.out.println("全部订单状态：" + orderService.getOrders());
    }


}