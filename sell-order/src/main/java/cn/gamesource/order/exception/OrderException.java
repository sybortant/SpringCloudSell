package cn.gamesource.order.exception;

import cn.gamesource.order.constants.enums.ResultEnum;

/**
 * 订单异常
 *
 * @author: LEIYU
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
