package cn.gamesource.product.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 扣减库存请求实体
 *
 * @author: LEIYU
 */
@Data
@AllArgsConstructor
public class DecreaseStockInput {

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;
}
