package cn.gamesource.order.persistence.repository;

import cn.gamesource.order.persistence.dao.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 订单详细
 *
 * @author: LEIYU
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
