package cn.gamesource.order.service;

import cn.gamesource.order.entity.dto.OrderDTO;

/**
 * @author: LEIYU
 */
public interface IOrderService {

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
