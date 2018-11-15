package cn.gamesource.product.persistence.repository;

import cn.gamesource.product.BaseTest;
import cn.gamesource.product.persistence.dao.ProductInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: LEIYU
 */
public class ProductInfoRepositoryTest extends BaseTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
        System.err.println(list);
        System.err.println("============");
    }
}