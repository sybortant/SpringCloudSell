package cn.gamesource.product.controller;

import cn.gamesource.product.entity.dto.CartDTO;
import cn.gamesource.product.entity.vo.ProductInfoVO;
import cn.gamesource.product.entity.vo.ProductVO;
import cn.gamesource.product.entity.vo.ResultVO;
import cn.gamesource.product.persistence.dao.ProductCategory;
import cn.gamesource.product.persistence.dao.ProductInfo;
import cn.gamesource.product.service.ICategoryService;
import cn.gamesource.product.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: LEIYU
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;


    /**
     * 1.查询所有上架的商品;
     * 2.获取类目type列表;
     * 3.查询类目;
     * 4.构造数据;
     */
    @GetMapping("/list")
    public ResultVO<ProductVO> list() {
        //1.查询所有上架的商品;
        List<ProductInfo> productInfoList = this.productService.findUpAll();
        //2.获取类目type列表;
        List<Integer> categoryType = productInfoList.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());
        //3.查询类目;
        List<ProductCategory> categoryList = this.categoryService.findByCategoryTypeIn(categoryType);
        //4.构造数据;
        List<ProductVO> productVOList = new ArrayList<>();
        ProductVO productVO;
        ProductInfoVO productInfoVO;
        List<ProductInfoVO> foods;
        for (ProductCategory category : categoryList) {
            productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());

            foods = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(category.getCategoryType())) {
                    productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    foods.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(foods);
            productVOList.add(productVO);
        }
        return ResultVO.ofSuccess(productVOList);
    }

    /**
     * @description: 订单服务获取商品列表 使用 RequestBody 必须用 Post
     * @author: LEIYU
     */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList) {
        return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList) {
        this.productService.decreaseStock(cartDTOList);
    }
}
