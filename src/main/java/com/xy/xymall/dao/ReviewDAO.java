package com.xy.xymall.dao;

import com.xy.xymall.entity.Product;
import com.xy.xymall.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDAO extends JpaRepository<Review,Integer> {
    List<Review> findByProductOrderByIdDesc(Product product);   //返回某产品对应的评论集合
    int countByProduct(Product product);                        //返回某产品评论的数量
}
