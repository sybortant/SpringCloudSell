package cn.gamesource.order.service.impl;

import cn.gamesource.order.client.ProductClient;
import cn.gamesource.order.constants.enums.OrderStatusEnum;
import cn.gamesource.order.constants.enums.PayStatusEnum;
import cn.gamesource.order.entity.dto.CartDTO;
import cn.gamesource.order.entity.dto.OrderDTO;
import cn.gamesource.order.persistence.dao.OrderDetail;
import cn.gamesource.order.persistence.dao.OrderMaster;
import cn.gamesource.order.persistence.dao.ProductInfo;
import cn.gamesource.order.persistence.repository.OrderDetailRepository;
import cn.gamesource.order.persistence.repository.OrderMasterRepository;
import cn.gamesource.order.service.IOrderService;
import cn.gamesource.order.utils.KeyUtil;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: LEIYU
 */
@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //查询商品信息(调用商品服务)
        List<String> productIdList = orderDTO.getOrderDetailList().stream().map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfo> productInfos = this.productClient.listForOrder(productIdList);
        String orderId = KeyUtil.genUniqueKey();
        //计算总价;
        BigDecimal orderAmount = BigDecimal.ZERO;
        for (OrderDetail detail : orderDTO.getOrderDetailList()) {
            for (ProductInfo productInfo : productInfos) {
                if (productInfo.getProductId().equals(detail.getProductId())) {
                    BigDecimal productPrice = productInfo.getProductPrice();
                    orderAmount = productPrice.multiply(BigDecimal.valueOf(detail.getProductQuantity())).add(orderAmount);
                    BeanUtils.copyProperties(productInfo, detail);
                    detail.setOrderId(orderId);
                    detail.setDetailId(KeyUtil.genUniqueKey());
                    //存入订单详情;
                    this.orderDetailRepository.save(detail);
                }
            }
        }
        //扣库存(调用商品服务)
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(o -> new CartDTO(o.getProductId(), o.getProductQuantity())).collect(Collectors.toList());
        this.productClient.decreaseStock(cartDTOList);
        //订单入库;
        OrderMaster order = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, order);
        order.setOrderAmount(orderAmount);
        order.setOrderStatus(OrderStatusEnum.NEW.getCode());
        order.setPayStatus(PayStatusEnum.WAIT.getCode());
        order.setOrderId(KeyUtil.genUniqueKey());

        orderMasterRepository.save(order);
        return orderDTO;
    }
}
