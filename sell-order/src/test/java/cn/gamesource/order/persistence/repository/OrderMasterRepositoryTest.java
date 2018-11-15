package cn.gamesource.order.persistence.repository;

import cn.gamesource.order.SellOrderApplicationTests;
import cn.gamesource.order.persistence.dao.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: LEIYU
 */
public class OrderMasterRepositoryTest extends SellOrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {
        OrderMaster insert = new OrderMaster();
        insert.setOrderId("1");
        insert.setBuyerAddress("sss");
        insert.setBuyerName("leiyu");
        insert.setBuyerOpenid("dfsfsd");
        insert.setBuyerPhone("181");
        insert.setOrderAmount(BigDecimal.TEN);
        insert.setOrderStatus(0);
        insert.setPayStatus(0);
        insert.setCreateTime(new Date());
        insert.setUpdateTime(new Date());
        OrderMaster newOrder = orderMasterRepository.save(insert);
        Assert.assertNotNull(newOrder);
    }
}