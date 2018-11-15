package cn.gamesource.product.common;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品返回数据封装
 *
 * @author: LEIYU
 */
public class ProductInfoOutput {
    /**
     * 产品ID
     */
    private String productId;
    /**
     * 产品名
     */
    private String productName;
    /**
     * 价格
     */
    private BigDecimal productPrice;
    /**
     * 库存
     */
    private Integer productStock;
    /**
     * 描述
     */
    private String productDescription;
    /**
     * 图标
     */
    private String productIcon;
    /**
     * 商品状态,0正常1下架
     */
    private Integer productStatus;
    /**
     * 分类iD
     */
    private Integer categoryType;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
