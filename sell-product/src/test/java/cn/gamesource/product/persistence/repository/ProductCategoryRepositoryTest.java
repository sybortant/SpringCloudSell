package cn.gamesource.product.persistence.repository;

import cn.gamesource.product.BaseTest;
import cn.gamesource.product.persistence.dao.ProductCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @author: LEIYU
 */
public class ProductCategoryRepositoryTest extends BaseTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findByCategoryTypeIn() {

        List<ProductCategory> list = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11, 12));
        System.err.println(list);
    }
}