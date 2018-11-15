package cn.gamesource.order.controller;

import cn.gamesource.order.constants.enums.ResultEnum;
import cn.gamesource.order.converter.OrderForm2OrderDTOConverter;
import cn.gamesource.order.entity.dto.OrderDTO;
import cn.gamesource.order.entity.form.OrderForm;
import cn.gamesource.order.entity.vo.ResultVO;
import cn.gamesource.order.exception.OrderException;
import cn.gamesource.order.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: LEIYU
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private IOrderService orderService;

    /**
     * 1.参数校验;
     * 2.查询商品信息(调用商品服务)
     * 3.计算总价;
     * 4.扣库存(调用商品服务)
     * 5.订单入库;
     */
    @PostMapping("/create")
    public ResultVO<Map> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("[创建订单]参数不正确, orderForm={}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        //类型转换;
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.info("[创建订单]购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = this.orderService.create(orderDTO);

        Map<String, Object> map = new HashMap<>();
        map.put("orderId", result.getOrderId());

        return ResultVO.ofSuccess(map);
    }
}
