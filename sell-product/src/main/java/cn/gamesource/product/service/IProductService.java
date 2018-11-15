package cn.gamesource.product.service;

import cn.gamesource.product.entity.dto.CartDTO;
import cn.gamesource.product.persistence.dao.ProductInfo;

import java.util.List;

/**
 * @author: LEIYU
 */
public interface IProductService {

    /**
     * 查询所有上架商品;
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 根据商品ID获取商品详细信息;
     *
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param cartDTOS
     */
    void decreaseStock(List<CartDTO> cartDTOS);

}
