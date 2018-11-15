package cn.gamesource.product.exception;

import cn.gamesource.product.constants.enums.ResultEnum;

/**
 * @author: LEIYU
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
