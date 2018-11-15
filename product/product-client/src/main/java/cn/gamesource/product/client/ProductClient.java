package cn.gamesource.product.client;

import cn.gamesource.product.common.DecreaseStockInput;
import cn.gamesource.product.common.ProductInfoOutput;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 调用服务的接口
 * product 表示需要调用的服务,
 *
 * @author: LEIYU
 */
@FeignClient(name = "product", path = "/product")
public interface ProductClient {
    /**
     * 获取商品列表
     *
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    /**
     * 扣减库存
     *
     * @param cartDTOList
     */
    @PostMapping("/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> cartDTOList);

}
