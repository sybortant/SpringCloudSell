package cn.gamesource.order.entity.dto;

import cn.gamesource.order.persistence.dao.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单
 *
 * @author: LEIYU
 */
@Data
public class OrderDTO {

    private String orderId;
    /**
     * 买家名字
     */
    private String buyerName;
    /**
     * 买家电话
     */
    private String buyerPhone;
    /**
     * 买家地址
     */
    private String buyerAddress;
    /**
     * 买家微信openid
     */
    private String buyerOpenid;
    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认0为新下单
     */
    private Integer orderStatus;
    /**
     * 支付状态, 默认0未支付
     */
    private Integer payStatus;
    /**
     * 订单详情;
     */
    private List<OrderDetail> orderDetailList;
}
