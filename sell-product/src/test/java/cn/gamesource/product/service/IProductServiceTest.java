package cn.gamesource.product.service;

import cn.gamesource.product.BaseTest;
import cn.gamesource.product.persistence.dao.ProductInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: LEIYU
 */
public class IProductServiceTest extends BaseTest {

    @Autowired
    private IProductService productService;

    @Test
    public void findUpAll() {
        List<ProductInfo> list = productService.findUpAll();
        System.err.println(list);
    }
}