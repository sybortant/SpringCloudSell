package cn.gamesource.product.service;

import cn.gamesource.product.persistence.dao.ProductCategory;

import java.util.List;

/**
 * @author: LEIYU
 */
public interface ICategoryService {

    /**
     * 根据类目编号查询分类
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
