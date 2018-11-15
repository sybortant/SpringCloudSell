package cn.gamesource.product.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 购物车DTO
 *
 * @author: LEIYU
 */
@Data
@AllArgsConstructor
public class CartDTO {

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;
}
