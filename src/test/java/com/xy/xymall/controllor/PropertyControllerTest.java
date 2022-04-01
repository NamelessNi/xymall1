package com.xy.xymall.controllor;

import com.xy.xymall.dao.CategoryDAO;
import com.xy.xymall.entity.Category;
import com.xy.xymall.entity.Property;
import com.xy.xymall.service.CategoryService;
import com.xy.xymall.service.PropertyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertyControllerTest {
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    PropertyService propertyService;
    @Autowired
    CategoryService categoryService;
    @Test
    public void add() {
        Property property=new Property();
        Category c= categoryDAO.findOne(1);
        property.setName("测试");
        property.setCategory(c);
        System.out.println(property);
        propertyService.add(property);
    }
}