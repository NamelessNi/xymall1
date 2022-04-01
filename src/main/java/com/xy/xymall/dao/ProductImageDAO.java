package com.xy.xymall.dao;

import com.xy.xymall.entity.Product;
import com.xy.xymall.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageDAO extends JpaRepository<ProductImage,Integer> {
    public List<ProductImage> findByProductAndTypeOrderByIdDesc(Product product, String type);
}
