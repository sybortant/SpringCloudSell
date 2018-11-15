package cn.gamesource.product.persistence.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: LEIYU
 */
@Data
@Entity
public class ProductInfo {

    /**
     * 产品ID
     */
    @Id
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
