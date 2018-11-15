package cn.gamesource.order.persistence.repository;

import cn.gamesource.order.SellOrderApplicationTests;
import cn.gamesource.order.persistence.dao.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: LEIYU
 */
public class OrderDetailRepositoryTest extends SellOrderApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void testSave() {
        OrderDetail detail = new OrderDetail();
        detail.setDetailId("111");
        detail.setOrderId("111");
        detail.setProductIcon("111");
        detail.setProductId("111");
        detail.setProductName("222");
        detail.setProductPrice(BigDecimal.TEN);
        detail.setProductQuantity(10);
        detail.setCreateTime(new Date());
        detail.setUpdateTime(new Date());
        OrderDetail newOrder = orderDetailRepository.save(detail);
        Assert.assertNotNull(newOrder);
    }

}