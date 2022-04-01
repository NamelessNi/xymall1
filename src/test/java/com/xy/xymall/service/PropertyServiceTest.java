package com.xy.xymall.service;

import com.xy.xymall.dao.PropertyDAO;
import com.xy.xymall.entity.Category;
import com.xy.xymall.entity.Property;
import com.xy.xymall.util.Page4Navigator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertyServiceTest {
    @Autowired
    PropertyDAO propertyDAO;
    @Autowired
    CategoryService categoryService;

    @Test
    public void add() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void get() {
        Property p =propertyDAO.findOne(1);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(p);
        System.out.println("ssssssssssssssssss");
    }

    @Test
    public void update() {
    }

    @Test
    public void list() {
        Category category = categoryService.get(1);

       // Sort sort = new Sort(Sort.Direction.DESC, "id");

       // Pageable pageable = new PageRequest(0, 5, sort);

        List<Property> pageFromJPA =propertyDAO.findByCategory(category);
        System.out.println("ssssssssssssssssssssssssssssssssss");
        System.out.println(pageFromJPA);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    }
}