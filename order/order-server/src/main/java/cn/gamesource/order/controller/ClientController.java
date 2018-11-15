package cn.gamesource.order.controller;

import cn.gamesource.order.client.ProductClient;
import cn.gamesource.order.entity.dto.CartDTO;
import cn.gamesource.order.persistence.dao.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author: LEIYU
 */
@Slf4j
@RestController
public class ClientController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfo> productInfos = this.productClient.listForOrder(Arrays.asList("164103465734242707", "157875196366160022"));
        log.info("数据={}", productInfos);
        return "OK";
    }

    @GetMapping("/decreaseStock")
    public String decreaseStock() {
        this.productClient.decreaseStock(Arrays.asList(new CartDTO("164103465734242707", 10)));
        return "OK";
    }

}
