package cn.gamesource.order.persistence.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 *
 * @author: LEIYU
 */
@Data
@Entity
public class OrderMaster {

    @Id
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

    private Date createTime;

    private Date updateTime;

}
