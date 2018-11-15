package cn.gamesource.product.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品
 *
 * @author: LEIYU
 */
@Data
public class ProductVO {

    /**
     * name : 热榜
     * type : 1
     * foods : [{"id":"123456","name":"皮蛋粥","price":1.2,"description":"好吃的皮蛋粥","icon":"http://xxx.com"}]
     */

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("categoryType")
    private Integer categoryType;
    @JsonProperty("foods")

    private List<ProductInfoVO> productInfoVOList;


}
