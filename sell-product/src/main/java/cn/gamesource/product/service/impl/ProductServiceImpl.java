package cn.gamesource.product.service.impl;

import cn.gamesource.product.constants.enums.ProductStatusEnum;
import cn.gamesource.product.constants.enums.ResultEnum;
import cn.gamesource.product.entity.dto.CartDTO;
import cn.gamesource.product.exception.ProductException;
import cn.gamesource.product.persistence.dao.ProductInfo;
import cn.gamesource.product.persistence.repository.ProductInfoRepository;
import cn.gamesource.product.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author: LEIYU
 */
@Slf4j
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return this.productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return this.productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseStock(List<CartDTO> cartDTOS) {
        for (CartDTO cartDTO : cartDTOS) {
            //查询商品,并判断商品是否存在,
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(cartDTO.getProductId());
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //判断库存是否充足;
            ProductInfo productInfo = productInfoOptional.get();
            Integer resultStock = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (resultStock < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            //重新设定库存
            productInfo.setProductStock(resultStock);
            this.productInfoRepository.save(productInfo);
        }
    }
}
