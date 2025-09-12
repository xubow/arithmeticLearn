package spring.stateMachine;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * @author chenyves
 * @description: (请在此添加描述)
 * @date 2025/1/7 10:00
 * @since JDK 1.8
 */
@Configuration
@ComponentScan("spring.stateMachine")
@EnableStateMachine
public class OrderStatusMachineConfig extends StateMachineConfigurerAdapter<OrderStatusEnum, OrderStatusTransitionEventEnum> {

    @Override
    public void configure(StateMachineStateConfigurer<OrderStatusEnum, OrderStatusTransitionEventEnum> states) throws Exception {
        //设定初始状态和结束状态
       states.withStates().initial(OrderStatusEnum.WAIT_PAY)
               .end(OrderStatusEnum.FINISH)
               //配置所有的状态
               .states(EnumSet.allOf(OrderStatusEnum.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatusEnum, OrderStatusTransitionEventEnum> transitions) throws Exception {
        //配置状态的流转以及对应的触发事件
        transitions.withExternal()
                .source(OrderStatusEnum.WAIT_PAY).target(OrderStatusEnum.WAIT_DELIVERY).event(OrderStatusTransitionEventEnum.PAYED)
                .and()
                .withExternal()
                .source(OrderStatusEnum.WAIT_DELIVERY).target(OrderStatusEnum.WAIT_RECEIVED).event(OrderStatusTransitionEventEnum.DELIVERY)
                .and()
                .withExternal()
                .source(OrderStatusEnum.WAIT_RECEIVED).target(OrderStatusEnum.FINISH).event(OrderStatusTransitionEventEnum.RECEIVED);
    }
}