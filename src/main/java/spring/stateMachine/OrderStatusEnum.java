
package spring.stateMachine;

/**
 * @description: (请在此添加描述)
 * @author chenyves
 * @date 2025/1/7 09:54
 * @since JDK 1.8
 */
public enum OrderStatusEnum {
    /**
     * 待支付
     */
    WAIT_PAY,
    /**
     * 待发货
     */
    WAIT_DELIVERY,
    /**
     * 待接收
     */
    WAIT_RECEIVED,
    /**
     * 结束
     */
    FINISH
}