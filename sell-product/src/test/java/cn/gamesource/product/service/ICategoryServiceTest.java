package cn.gamesource.product.service;

import cn.gamesource.product.BaseTest;
import cn.gamesource.product.persistence.dao.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: LEIYU
 */
public class ICategoryServiceTest extends BaseTest {

    @Autowired
    private ICategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        System.err.println(list);
    }
}