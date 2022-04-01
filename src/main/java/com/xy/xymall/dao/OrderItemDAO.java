package com.xy.xymall.dao;

import com.xy.xymall.entity.Order;
import com.xy.xymall.entity.OrderItem;
import com.xy.xymall.entity.Product;
import com.xy.xymall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemDAO extends JpaRepository<OrderItem,Integer> {
    List<OrderItem> findByOrderOrderByIdDesc(Order order);
    List<OrderItem> findByProduct(Product product);
    List<OrderItem> findByUserAndOrderIsNull(User user);
}
