package com.xy.xymall.dao;

import com.xy.xymall.entity.Order;
import com.xy.xymall.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order,Integer> {
    public List<Order> findByUserAndStatusNotOrderByIdDesc(User user, String status);
}
