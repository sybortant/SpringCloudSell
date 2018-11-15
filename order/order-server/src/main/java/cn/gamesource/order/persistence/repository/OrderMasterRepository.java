package cn.gamesource.order.persistence.repository;

import cn.gamesource.order.persistence.dao.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 订单
 *
 * @author: LEIYU
 */
@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {


}
