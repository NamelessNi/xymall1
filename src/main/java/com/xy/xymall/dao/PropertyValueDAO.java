package com.xy.xymall.dao;

import com.xy.xymall.entity.Product;
import com.xy.xymall.entity.Property;
import com.xy.xymall.entity.PropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyValueDAO extends JpaRepository<PropertyValue,Integer> {
    List<PropertyValue> findByProductOrderByIdDesc(Product product);
    PropertyValue getByPropertyAndProduct(Property property, Product product);
}
